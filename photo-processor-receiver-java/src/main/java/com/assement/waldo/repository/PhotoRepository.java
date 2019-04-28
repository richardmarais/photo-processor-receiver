package com.assement.waldo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assement.waldo.model.PhotoEntity;

@Repository
public interface PhotoRepository extends JpaRepository<PhotoEntity, UUID> {
	
}
