package com.uhyo.backend_data_management.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@RestController
public class FileController {

    // ★ Seiji の指定ディレクトリ
    private static final String FILE_DIR = "/home/ssuzuki/uhyo_project/frontend/public/cards";

    /**
     * GET /files
     * ファイル一覧を返す
     */
    @GetMapping("/files")
    public List<String> listFiles() {

        File dir = new File(FILE_DIR);

        if (!dir.exists() || !dir.isDirectory()) {
            return List.of();
        }

        File[] files = dir.listFiles();

        if (files == null) {
            return List.of();
        }

        return Arrays.stream(files)
                .filter(File::isFile)
                .map(File::getName)
                .collect(Collectors.toList());
    }

    /**
     * POST /download
     * 指定されたファイルを ZIP にまとめて返す
     */
    @PostMapping("/download")
    public ResponseEntity<byte[]> downloadZip(@RequestBody List<String> filenames) throws IOException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ZipOutputStream zos = new ZipOutputStream(baos);

        File baseDir = new File(FILE_DIR);

        for (String name : filenames) {

            File file = new File(baseDir, name);

            if (!file.exists() || !file.isFile()) {
                continue;
            }

            zos.putNextEntry(new ZipEntry(name));
            Files.copy(file.toPath(), zos);
            zos.closeEntry();
        }

        zos.close();
        byte[] zipBytes = baos.toByteArray();

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"download.zip\"");
        headers.set(HttpHeaders.CONTENT_TYPE, "application/zip");

        return new ResponseEntity<>(zipBytes, headers, HttpStatus.OK);
    }
}
