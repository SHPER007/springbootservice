package com.example.springbootservice;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:JwtTest
 * Description:TODO
 * Author:SunHang
 * Date:2024/6/17 23:12
 */
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
        String string = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9" +
                ".eyJ1c2VyIjp7Im5hbWUiOiIgSCIsImlkIjoxfSwiZXhwIjoxNzE4NjgxMjM3fQ" +
                "._9Z9zrxG9W31cGL2RSIRjV22_rFDs2Y9L0_mze3wS4o";
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256("qwerasdf1002")).build().verify(string);
        Map<String, Claim> claims = decodedJWT.getClaims();
        Claim user = claims.get("user");
        System.out.println(user);
    }
}
