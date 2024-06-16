package com.example.springbootservice.services;

import com.example.springbootservice.paramdto.LoginRequestDtoParam;
import com.example.springbootservice.paramdto.LoginResponseDto;

/**
 * ClassName:LoginService
 * Description:TODO
 * Author:SunHang
 * Date:2024/6/16 14:37
 */
public interface LoginService {
    LoginResponseDto login(LoginRequestDtoParam loginRequestDtoParam);

}
