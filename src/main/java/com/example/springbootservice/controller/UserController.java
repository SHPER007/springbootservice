package com.example.springbootservice.controller;

import com.example.springbootservice.mysqlbean.User;
import com.example.springbootservice.response.BaseResponseResult;
import com.example.springbootservice.services.UserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName:LoginControl
 * Package:com.example.springbootservice.control
 * Description:TODO
 * Date:2024/3/30 0030 0:21
 * Author:2498897200@qq.com
 */
@Slf4j
@RestController
@RequestMapping("/user")
@RefreshScope
public class UserController {
    @Resource
    private UserService userService;

    @Value("${start.time}")
    private Long startTime;

    @Value("${active.name}")
    private String name;

    @GetMapping(value = "/{userid}")
    public BaseResponseResult getUserById(@PathVariable Integer userid){
        User user = userService.getUserByIdWithRoles(userid);
        return BaseResponseResult.success("OK", user);
    }

    @GetMapping(value = "/test")
    public BaseResponseResult getUserById(){
        return BaseResponseResult.success(name);
    }
}
