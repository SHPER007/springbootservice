package com.example.springbootservice.control;

import com.example.springbootservice.javabean.User;
import com.example.springbootservice.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:LoginControl
 * Package:com.example.springbootservice.control
 * Description:TODO
 * Date:2024/3/30 0030 0:21
 * Author:2498897200@qq.com
 */
@Slf4j
@RestController
@RequestMapping("/index")
public class LoginControl {


    @RequestMapping(value = "/home",method = {RequestMethod.POST})
    public ResponseResult<?> index(@RequestBody User user){
        log.info("日志打印{}",user.getName());
        return new ResponseResult<>(200, "访问成功");
    }

}
