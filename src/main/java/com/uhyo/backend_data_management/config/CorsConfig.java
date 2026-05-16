// ★★★ ここが最重要 ★★★
// backend_data_management の Application.java と同じ階層に合わせること
// これがズレると Spring Boot がこのクラスをスキャンしない
package com.uhyo.backend_data_management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    // ★ Spring Boot に CORS 設定を登録する Bean
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {

            // ★ すべてのパス（/**）に対して CORS を許可
            @Override
            public void addCorsMappings(CorsRegistry registry) {

                registry.addMapping("/**")  // ← /images/random も /images/file/{id} も全部対象
                        .allowedOrigins("http://localhost:5173") // Vue の URL
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);

                // ★ これで Vue → Spring Boot の通信がブロックされなくなる
            }
        };
    }
}
