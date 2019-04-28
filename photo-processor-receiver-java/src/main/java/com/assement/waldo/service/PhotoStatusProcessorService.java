package com.assement.waldo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.assement.waldo.model.PhotoEntity;
import com.assement.waldo.model.PhotoEntity.PhotoStatus;
import com.assement.waldo.model.PhotoThumbnailsEntity;
import com.assement.waldo.repository.PhotoRepository;
import com.assement.waldo.repository.PhotoThumbnailRepository;
import com.assement.waldo.util.ResizeImage;

@Component
public class PhotoStatusProcessorService {
	
	@Autowired
	private PhotoRepository photoRepository;
	
	@Autowired
	private PhotoThumbnailRepository photoThumbnailRepository;

	public void processPhotoForId(UUID uuid) {
		PhotoEntity photoEntity = null;
		try {
			photoEntity = photoRepository.getOne(uuid);
			photoEntity.setStatus(PhotoStatus.processing);
			System.out.println(uuid+" processing");
			photoEntity = photoRepository.save(photoEntity);
			String resizedUrl = ResizeImage.resize(photoEntity.getUrl());
			if (resizedUrl != null) {
				PhotoThumbnailsEntity photoThumbnailsEntity = new PhotoThumbnailsEntity();
				photoThumbnailsEntity.setPhoto(photoEntity);
				photoThumbnailsEntity.setHeight(ResizeImage.HEIGHT);
				photoThumbnailsEntity.setWidth(ResizeImage.WIDTH);
				photoThumbnailsEntity.setUuid(UUID.randomUUID());
				photoThumbnailsEntity.setUrl(resizedUrl);
				photoThumbnailsEntity.setCreated_at(LocalDateTime.now());
				photoThumbnailRepository.save(photoThumbnailsEntity);
				photoEntity.setStatus(PhotoStatus.completed);
				photoEntity = photoRepository.save(photoEntity);
				System.out.println(uuid+" completed");
			} else {
				photoEntity.setStatus(PhotoStatus.failed);
				photoEntity = photoRepository.save(photoEntity);
				System.out.println(uuid+" failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			photoEntity.setStatus(PhotoStatus.failed);
			photoEntity = photoRepository.save(photoEntity);
			System.out.println(uuid+" failed");
		}
	}
	
	public List<PhotoThumbnailsEntity> getPhotoThumbnails() {
		List<PhotoThumbnailsEntity> photoThumbnailsEntitys = photoThumbnailRepository.findAll();
		return photoThumbnailsEntitys;
	}
}
