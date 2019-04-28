package com.assement.waldo.dto;

import java.time.LocalDateTime;

public class PhotoThumbnailsDto {
    private String uuid;
    
    private PhotoDto photo;
    
	private Integer width;
    
	private Integer height;

	private String url;

    private LocalDateTime created_at;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public PhotoDto getPhoto() {
		return photo;
	}

	public void setPhoto(PhotoDto photo) {
		this.photo = photo;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
    
}
