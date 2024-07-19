package com.example.springbootservice.conf.utils;

import com.example.springbootservice.domain.po.User;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GenerateJwtUtilTest {

    @Resource
    GenerateJwtUtil generateJwtUtil;

    @Test
    void generateJwt() {
        User user = new User();
        user.setUserid(10009);
        user.setNickName("sunhang");
        String token = generateJwtUtil.generateToken(user);
        Integer userIdFromToken = generateJwtUtil.getUserIdFromToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7Im5hbWUiOiJhZG1pbiIsImlkIjoxMDAwOX0sImV4cCI6MTcyMTA2Mjg4MH0.S1_CF9_4IC0zg_acyV3irXpY5Hn3IVariWP1eBWGKfk");
        System.out.println(userIdFromToken);
    }

}