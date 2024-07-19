package com.example.springbootservice.mapper;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class UserMapperTest {

    @Resource
    NavInfoMapper navInfoMapper;

    @Resource
    UserMapper userMapper;

    @Test
    void getUserByIdWithRoles() {

    }

    @Test
    void userList() {
        LocalDateTime localDateTime = LocalDateTime.now(ZoneOffset.UTC)
                .withHour(0)
                .withMinute(0)
                .withSecond(0)
                .withNano(0);

        // 转换为UTC的ZonedDateTime
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneOffset.UTC);

        // 减去8小时
        ZonedDateTime timeMinus8Hours = zonedDateTime.minusHours(8);

        // 确保时间在每天的开始
        ZonedDateTime startOfDayMinus8Hours = timeMinus8Hours.withHour(0)
                .withMinute(0)
                .withSecond(0)
                .withNano(0);

        // 转换为毫秒时间戳
        long everyDayStartTime = startOfDayMinus8Hours.toInstant().toEpochMilli();


        LocalDateTime a = LocalDateTime.now(ZoneOffset.UTC).withHour(0).withMinute(0).withSecond(0).withNano(0);
        long b = a.toInstant(ZoneOffset.UTC).toEpochMilli();
        long everyDayEndTime = everyDayStartTime + TimeUnit.DAYS.toMillis(1) - 1;

        // 输出结果
        System.out.println("Start time after subtracting 8 hours: " + everyDayStartTime);
    }

    @Test
    void pageUserList() {
    }
}