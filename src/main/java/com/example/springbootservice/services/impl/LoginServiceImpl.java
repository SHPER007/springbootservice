package com.example.springbootservice.services.impl;

import com.example.springbootservice.conf.utils.GenerateJwtUtil;
import com.example.springbootservice.mapperdao.UserMapper;
import com.example.springbootservice.mysqlbean.User;
import com.example.springbootservice.paramdto.LoginRequestDtoParam;
import com.example.springbootservice.resdto.LoginResDto;
import com.example.springbootservice.services.LoginService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * ClassName:LoginServiceImpl
 * Description:TODO
 * Author:SunHang
 * Date:2024/6/16 14:38
 */
@Slf4j
@Service
public class LoginServiceImpl implements LoginService {
    /**
    *Params:
    *Return:
    *Description: 下发token逻辑
    */
    @Resource
    GenerateJwtUtil GenerateJwtUtil;
    @Resource
    UserMapper userMapper;
    @Resource
    GenerateJwtUtil generateJwtUtil;
    
    public LoginResDto login(LoginRequestDtoParam loginRequestDtoParam) {
        Integer userid = loginRequestDtoParam.getUserid();
        String userInputPassword = loginRequestDtoParam.getPassword();
        if (userid == null || userInputPassword == null  || userInputPassword.isBlank()) {
            return null;
        }
        User userBean = userMapper.getUserByIdWithRoles(userid);
        if (userBean == null) {
            return null;
        }
        String password = userBean.getPassword();
        if (!password.equals(userInputPassword)) {
            return null;
        }
        // 下发token
        try {
            String token = generateJwtUtil.generateToken(userBean);
            LoginResDto loginResponseDto = new LoginResDto();
            loginResponseDto.setUserid(userBean.getUserid());
            loginResponseDto.setToken(token);
            return loginResponseDto;
        }catch (Exception e){
            log.error("生成jwt-token失败");
            LoginResDto loginResponseDto = new LoginResDto();
            loginResponseDto.setToken("fail");
            return loginResponseDto;
        }
    }
}
