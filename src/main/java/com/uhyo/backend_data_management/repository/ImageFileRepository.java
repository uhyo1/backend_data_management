package com.uhyo.backend_data_management.repository;

import com.uhyo.backend_data_management.entity.ImageFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ImageFileRepository extends JpaRepository<ImageFile, Integer> {

    @Query(value = "SELECT * FROM app.image_files ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    ImageFile findRandomImage();
}
