package com.assement.waldo.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.assement.waldo.model.PhotoEntity.PhotoStatus;

public class PhotoDto {

    private UUID uuid;
    
    private String url;
    
    private PhotoStatus status;
    
    private LocalDateTime created_at;

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public PhotoStatus getStatus() {
		return status;
	}

	public void setStatus(PhotoStatus status) {
		this.status = status;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
    
}
