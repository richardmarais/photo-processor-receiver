package com.assement.waldo.model;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "photo_thumbnails")
public class PhotoThumbnailsEntity {
	
	@Id
	@Column(name = "uuid")
    private UUID uuid;
    
	@OneToOne
    private PhotoEntity photo;
    
	@Column(name = "width", nullable = false)
	private Integer width;
    
	@Column(name = "height", nullable = false)
	private Integer height;

	@Column(name = "url", nullable = false)
	private String url;

	@Column(name = "created_at", nullable = false)
    private LocalDateTime created_at;

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public PhotoEntity getPhoto() {
		return photo;
	}

	public void setPhoto(PhotoEntity photo) {
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
