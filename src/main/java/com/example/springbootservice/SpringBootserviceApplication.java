package com.example.springbootservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

// EnableFeignClients注解开启Feign的功能
@EnableFeignClients
@SpringBootApplication
public class SpringBootserviceApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootserviceApplication.class, args);
    }

}
