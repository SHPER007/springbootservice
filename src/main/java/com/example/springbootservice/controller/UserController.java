package com.example.springbootservice.controller;

import com.example.springbootservice.mysqlbean.User;
import com.example.springbootservice.response.BaseResponseResult;
import com.example.springbootservice.services.UserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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
public class UserController {
    @Resource
    private UserService userService;

    @Value("${start.time}")
    private Long startTime;

    @GetMapping(value = "/{userid}")
    public BaseResponseResult getUserById(@PathVariable Integer userid){
        System.out.println(startTime);
        User user = userService.getUserById(userid);
        return BaseResponseResult.success("OK", user);
    }

}
