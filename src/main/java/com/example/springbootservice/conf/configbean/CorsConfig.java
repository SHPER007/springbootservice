package com.example.springbootservice.conf.configbean;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName:CorsConfig
 * Description:配置csor 跨域访问参数
 * Author:SunHang
 * Date:2024/4/14 17:47
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:3000") // 允许所有源，可替换为具体的源地址
            .allowedMethods("*") // 允许所有 HTTP 方法
            .allowedHeaders("*") // 允许所有请求头
            .allowCredentials(true) // 允许携带凭据（如 Cookies）
            .maxAge(3600); // 预检请求缓存有效期为 1 小时
}
}
