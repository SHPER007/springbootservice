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
        HashMap<String, Object> userMap = new HashMap<>();
        userMap.put("id", user.getId());
        userMap.put("name",user.getNickName());
        String token = JWT.create()
                .withClaim("userMapKey", userMap)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000*60*60*12))
                .sign(Algorithm.HMAC256("secreter"));
        return token;
    }

    public Map<String, Object> parseToken(String token) {
        //定义字符串模拟用户传递过来的token
        try {
            DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256("secreter")).build().verify(token);
            Map<String, Claim> claims = decodedJWT.getClaims();
            return claims.get("userMapKey").asMap();
        }catch (Exception e){
            log.info("解析token异常{}", e.getMessage());
            return null;
        }
    }
}
