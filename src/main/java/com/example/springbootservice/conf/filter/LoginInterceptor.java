package com.example.springbootservice.conf.filter;

import com.example.springbootservice.conf.utils.GenerateJwtUtil;
import com.example.springbootservice.conf.utils.ThreadLocalUtil;
import jakarta.annotation.Resource;
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
    @Resource
    GenerateJwtUtil generateJwtUtil;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            return true;
        }
        if(requestURI.startsWith("/refreshToken")){
            return true;
        }
        String token = request.getHeader("Authorization");
        Map<String, Object> tokenMap = generateJwtUtil.parseToken(token);
        if (tokenMap == null || tokenMap.isEmpty()) {
            response.setStatus(401);
            return false;
        }
        // 存储token到threadLocal中  存userid到ThreadLocalUtil中
        ThreadLocalUtil.set(generateJwtUtil.getUserIdFromToken(token));
        return true;
        }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //  清空threadLocal中的数据
        ThreadLocalUtil.remove();
    }
}

