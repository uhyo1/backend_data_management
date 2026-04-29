package com.uhyo.backend_data_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uhyo.backend_data_management.repository.PswdExpiredRepository;

/**
 * DB 接続確認用のコントローラ
 * /data/db-test にアクセスすると DB のデータ件数を返す
 */
@RestController
public class DbTestController {

    @Autowired
    private PswdExpiredRepository repository;

    /**
     * DB の pswd_expired テーブルの件数を返すテスト API
     */
    @GetMapping("/data/db-test")
    public String testDb() {
        long count = repository.count();
        return "pswd_expired の件数: " + count;
    }
}
