package com.assement.waldo.model;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

@Entity
@Table(name = "photos")
@TypeDef(name = "pgsql_enum", typeClass = PostgreSQLEnumType.class)
public class PhotoEntity {
	
	public enum PhotoStatus {
		pending,
		completed,
		processing,
		failed
	}
	
	@Id
	@Column(name = "uuid")
    private UUID uuid;
    
	@Column(name = "url", nullable = false)
    private String url;
    
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "photo_status", nullable = false)
    @Type( type = "pgsql_enum" )
    private PhotoStatus status;
    
	@Column(name = "created_at", nullable = false)
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

	@Override
	public String toString() {
		return "PhotoEntity [uuid=" + uuid + ", url=" + url + ", status=" + status + ", created_at=" + created_at + "]";
	}

}
