package com.example.springbootservice.services.impl;

import com.example.springbootservice.domain.responsevo.UserPlanResDto;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class UserPlanServiceImplTest {

    @Resource
    UserPlanServiceImpl userPlanServiceImpl;

    @Test
    void  test(){
        UserPlanResDto userPlan = userPlanServiceImpl.getUserPlan();
        System.out.println(userPlan);
    }

    @Test
    void clearUserPlanForToday() {
        Boolean b = userPlanServiceImpl.clearUserPlanForToday();
        System.out.println(b);
    }
}