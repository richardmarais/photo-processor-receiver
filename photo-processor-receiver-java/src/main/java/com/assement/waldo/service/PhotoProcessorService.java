package com.assement.waldo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.assement.waldo.dto.PhotoDto;
import com.assement.waldo.repository.PhotoRepository;
import com.assement.waldo.util.ObjectMapperUtils;

@Component
public class PhotoProcessorService {
	
	@Autowired
	private PhotoRepository photoRepository;

	/**
	 * Gets the list of photos from the datasource
	 * @return List<PhotoDto>
	 */
	public List<PhotoDto> getPhotos() {
		return ObjectMapperUtils.mapAll(photoRepository.findAll(), PhotoDto.class);
	}

}
