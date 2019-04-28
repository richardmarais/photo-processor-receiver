package com.assement.waldo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assement.waldo.model.PhotoThumbnailsEntity;

@Repository
public interface PhotoThumbnailRepository extends JpaRepository<PhotoThumbnailsEntity, UUID> {
	
}
