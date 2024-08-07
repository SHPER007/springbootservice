package com.example.springbootservice.controller;

import com.example.springbootservice.domain.params.LoginParam;
import com.example.springbootservice.domain.responsevo.LoginResDto;
import com.example.springbootservice.domain.baseresponse.BaseResponseResult;
import com.example.springbootservice.services.LoginService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public BaseResponseResult login(@RequestBody LoginParam loginParam) {
        LoginResDto loginResponseDto = loginService.login(loginParam);
        if (loginResponseDto == null) {
            return BaseResponseResult.fail(HttpStatus.BAD_REQUEST.value(),"账号与密码不匹配，请重新输入");
        } else if (("fail").equals(loginResponseDto.getToken())) {
            return BaseResponseResult.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(),"生成token失败");
        }
        return BaseResponseResult.success(HttpStatus.OK.value(),"OK", loginResponseDto);
    }


    @GetMapping("refreshToken")
    public BaseResponseResult refreshToken(@RequestParam Integer userid ) {
        LoginResDto loginResDto = loginService.refreshToken(userid);
        return BaseResponseResult.success(HttpStatus.OK.value(),"OK", loginResDto);
    }
}



