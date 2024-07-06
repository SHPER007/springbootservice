package com.example.springbootservice.exception;

import com.example.springbootservice.conf.utils.GenerateJwtUtil;
import com.example.springbootservice.conf.utils.ThreadLocalUtil;
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
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            return true;
        }
        String token = request.getHeader("Authorization");
        GenerateJwtUtil generateJwtUtil = new GenerateJwtUtil();
        Map<String, Object> tokenMap = generateJwtUtil.parseToken(token);
        if (tokenMap == null || tokenMap.isEmpty()) {
            response.setStatus(401);
            return false;
        }
        // 存储token到threadlocal中
        ThreadLocalUtil.set(tokenMap);
        return true;
        }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        清空threadloacl中的数据
        ThreadLocalUtil.remove();
    }
}

