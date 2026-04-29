package com.uhyo.backend_data_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * backend_data_management サービスのエントリーポイント
 * このクラスから Spring Boot アプリケーションが起動する
 */
@SpringBootApplication
public class BackendDataManagementApplication {

    public static void main(String[] args) {
        // Spring Boot アプリケーションを起動する
        SpringApplication.run(BackendDataManagementApplication.class, args);
    }
}
