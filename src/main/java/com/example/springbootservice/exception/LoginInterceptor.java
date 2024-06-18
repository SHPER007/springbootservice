package com.example.springbootservice.exception;

import com.example.springbootservice.conf.utils.GenerateJwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

/**
 * ClassName:LoginInterceptor
 * Description:添加拦截器对象对象注入到容器中
 * Author:SunHang
 * Date:2024/6/18 22:42
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        GenerateJwtUtil generateJwtUtil = new GenerateJwtUtil();
        Map<String, Object> tokenMap = generateJwtUtil.parseToken(token);
        if (tokenMap == null || tokenMap.isEmpty()) {
            response.setStatus(401);
            return false;
        }
        return true;

        }
}

