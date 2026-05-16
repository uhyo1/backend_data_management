package com.uhyo.backend_data_management.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "image_files", schema = "app")
@Data
public class ImageFile {

    @Id
    @Column(name = "image_id")
    private Integer imageId;

    @Column(name = "file_path")
    private String filePath;

    @Column(name = "register_time")
    private LocalDateTime registerTime;

    @Column(name = "update_time")
    private LocalDateTime updateTime;
}
