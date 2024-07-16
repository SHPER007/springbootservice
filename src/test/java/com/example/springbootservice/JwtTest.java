package com.example.springbootservice;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:JwtTest
 * Description:TODO
 * Author:SunHang
 * Date:2024/6/17 23:12
 */
@SpringBootTest
public class JwtTest {
    @Test
    public  void generateToken() {
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("name"," H");
        String token = JWT.create()
                .withClaim("user", claims)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 12))
                .sign(Algorithm.HMAC256("qwerasdf1002"));
        System.out.println(token);
    }
    @Test
    public void parseToken() {
        //定义字符串模拟用户传递过来的token
        String string = "123";
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256("qwerasdf1002")).build().verify(string);
        Map<String, Claim> claims = decodedJWT.getClaims();
        Map<String, Object> user = claims.get("user").asMap();
        System.out.println(user);
    }


}


