package com.uhyo.backend_data_management.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import com.uhyo.backend_data_management.entity.ImageFile;
import com.uhyo.backend_data_management.Service.ImageFileService;
import lombok.RequiredArgsConstructor;
import java.io.File;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/images")
@RequiredArgsConstructor
public class ImageFileController {

    /**
    * 全画像のメタデータ一覧を返す API
    * GET /images/all
    */
    @GetMapping("/all")
    public List<ImageFile> getAllImages() {
        return service.getAllImages();
    }

    private final ImageFileService service;

    /**
     * ランダム画像のメタデータを返す API
     * GET /images/random
     */
    @GetMapping("/random")
    public ImageFile getRandomImage() {
        return service.getRandomImage();
    }

    /**
     * ★★★ ここに画像返却 API を追加する ★★★
     * GET /images/file/{id}
     * 
     * Vue 側の <img> が読み込めるように、
     * 実際の JPEG バイナリを HTTP レスポンスとして返す。
     */
    @GetMapping("/file/{id}")
    public ResponseEntity<Resource> getImageFile(@PathVariable Integer id) {

        // DB から image_id に対応するレコードを取得
        ImageFile image = service.getImageById(id);
        if (image == null) {
            return ResponseEntity.notFound().build();
        }

        // 実際のファイルパスを File として扱う
        File file = new File(image.getFilePath());
        if (!file.exists()) {
            return ResponseEntity.notFound().build();
        }

        // Spring が返せる Resource に変換
        Resource resource = (Resource) new FileSystemResource(file);

        // JPEG として返却
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(resource);
    }
}



