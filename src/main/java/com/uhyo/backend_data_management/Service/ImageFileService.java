package com.uhyo.backend_data_management.Service;

import com.uhyo.backend_data_management.entity.ImageFile;
import com.uhyo.backend_data_management.repository.ImageFileRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageFileService {

    private final ImageFileRepository repository;

    // ランダム画像1件
    public ImageFile getRandomImage() {
        return repository.findRandomImage();
    }

    // ID指定で画像1件
    public ImageFile getImageById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    // ★ これがサムネイル一覧用のメソッド（唯一の getAllImages）
    public List<ImageFile> getAllImages() {
        return repository.findAll();
    }
}
