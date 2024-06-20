package com.example.springbootservice.controller;

import com.example.springbootservice.paramdto.LoginRequestDtoParam;
import com.example.springbootservice.paramdto.LoginResponseDto;
import com.example.springbootservice.response.BaseResponseResult;
import com.example.springbootservice.services.LoginService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:LoginController
 * Description:TODO
 * Author:SunHang
 * Date:2024/6/16 14:35
 */

@Slf4j
@RestController
@RequestMapping("/")
public class LoginController {
    @Resource
    LoginService loginService;
    /**
    *Params:username  password
    *Return: token
    *Description: token下发接口
    */
    @PostMapping("login")
    public BaseResponseResult login(@RequestBody LoginRequestDtoParam loginRequestDtoParam) {
        LoginResponseDto loginResponseDto = loginService.login(loginRequestDtoParam);
        if (loginResponseDto == null) {
            return BaseResponseResult.fail(HttpStatus.BAD_REQUEST.value(),"账号与密码不匹配，请重新输入");
        } else if (("fail").equals(loginResponseDto.getToken())) {
            return BaseResponseResult.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(),"生成token失败");
        }
        return BaseResponseResult.success(HttpStatus.OK.value(),"OK", loginResponseDto);
    }
}



