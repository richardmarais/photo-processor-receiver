package com.assement.waldo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.assement.waldo.dto.PhotoDto;
import com.assement.waldo.service.PhotoProcessorService;

@RestController
@RequestMapping("/photos")
public class PhotoProcessorController {

	@Autowired 
	private PhotoProcessorService photoProcessorService;

	/**
	 * Return photo records in JSON format
	 * 
	 * @return List<PhotoDto>
	 */
	@GetMapping("/pending")
	@ResponseStatus(HttpStatus.OK)
	public List<PhotoDto> getPhotos() {
		return photoProcessorService.getPhotos();
	}
}
