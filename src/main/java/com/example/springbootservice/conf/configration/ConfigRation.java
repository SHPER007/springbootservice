package com.example.springbootservice.conf.configration;

import com.example.springbootservice.conf.utils.RedisLockUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName:Configer
 * Package:com.example.springbootservice.configration
 * Description:TODO
 * Date:2024/4/1 0001 0:45
 * Author:2498897200@qq.com
 */
@Configuration
public class ConfigRation {

    @Bean
    public RedisLockUtil redisLockUtil(){
        return new RedisLockUtil();

    }
}
