package com.example.springbootservice.conf.configbean;

import com.example.springbootservice.conf.filter.LoginInterceptor;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName:CorsConfig
 * Description: 拦截器 配置cors 跨域访问参数
 * Author:SunHang
 * Date:2024/4/14 17:47
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Resource
    private LoginInterceptor loginInterceptor;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:8080") // 允许所有源，可替换为具体的源地址
            .allowedMethods("*") // 允许所有 HTTP 方法
            .allowedHeaders("*") // 允许所有请求头
            .allowCredentials(true) // 允许携带凭据（如 Cookies）
            .maxAge(3600); // 预检请求缓存有效期为 1 小时
    }
    /**
    *Params:
    *Return:
    *Description:配置请求拦截器，登录接口和注册接口不拦截
    */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).excludePathPatterns("/login");
    }
}
