package com.example.springbootservice.conf.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.springbootservice.mysqlbean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:JwtUtils
 * Description:TODO
 * Author:SunHang
 * Date:2024/6/16 16:04
 */
@Slf4j
@Component
public class GenerateJwtUtil {

    @Value("${jwt.userInfoKey}")
    private String userInfoKey;

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiresMs}")
    private int expiresMs;

    public String generateToken(User user) {
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("id", user.getId());
        claims.put("name",user.getNickName());
        String token = JWT.create()
                .withClaim("user", claims)
                .withExpiresAt(new Date(System.currentTimeMillis() + expiresMs))
                .sign(Algorithm.HMAC256(secret));
        return token;
    }

    public Map<String, Object> parseToken(String string) {
        //定义字符串模拟用户传递过来的token
        try {
            DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256(secret)).build().verify(string);
            Map<String, Claim> claims = decodedJWT.getClaims();
            return claims.get(userInfoKey).asMap();
        }catch (Exception e){
            log.info("解析token异常{}", e.getMessage());
            return null;
        }
    }
}
