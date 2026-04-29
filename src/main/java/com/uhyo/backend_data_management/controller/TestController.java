package com.uhyo.backend_data_management.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 動作確認用のコントローラ
 * /data/test にアクセスすると文字列を返すだけの簡単な API
 */
@RestController
public class TestController {

    /**
     * GET /data/test にアクセスされた時に実行されるメソッド
     * サービスが正常に動いているか確認するためのエンドポイント
     */
    @GetMapping("/data/test")
    public String test() {
        return "Hello from backend_data_management!";
    }
}
