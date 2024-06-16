package com.example.springbootservice.conf.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * ClassName:JwtUtils
 * Description:TODO
 * Author:SunHang
 * Date:2024/6/16 16:04
 */
@Component
public class GenerateJwtUtil {
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiresMs}")
    private int expiresMs;


}
