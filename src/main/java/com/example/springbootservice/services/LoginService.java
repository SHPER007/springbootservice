package com.example.springbootservice.services;

import com.example.springbootservice.domain.params.LoginParam;
import com.example.springbootservice.domain.responsevo.LoginResVo;

/**
 * ClassName:LoginService
 * Description:TODO
 * Author:SunHang
 * Date:2024/6/16 14:37
 */
public interface LoginService {
    LoginResVo login(LoginParam loginParam);

    LoginResVo refreshToken(Integer userid);
}
