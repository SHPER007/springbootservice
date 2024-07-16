package com.example.springbootservice.services.impl;

import com.example.springbootservice.conf.utils.GenerateJwtUtil;
import com.example.springbootservice.mapper.UserMapper;
import com.example.springbootservice.domain.po.User;
import com.example.springbootservice.domain.params.LoginParam;
import com.example.springbootservice.domain.responsevo.LoginResVo;
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
    
    public LoginResVo login(LoginParam loginParam) {
        Integer userid = loginParam.getUserid();
        String userInputPassword = loginParam.getPassword();
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
        try{
            String token = generateJwtUtil.generateToken(userBean);
            LoginResVo loginResponseDto = new LoginResVo();
            loginResponseDto.setUserid(userBean.getUserid());
            loginResponseDto.setToken(token);
            return loginResponseDto;
        }catch (Exception e){
            log.error("生成jwt-token失败");
            LoginResVo loginResponseDto = new LoginResVo();
            loginResponseDto.setToken("fail");
            return loginResponseDto;
        }
    }

    @Override
    public LoginResVo refreshToken(Integer userid) {
        User userBean = userMapper.getUserByIdWithRoles(userid);
        // 下发token
        try {
            String token = generateJwtUtil.generateToken(userBean);
            LoginResVo loginResponseDto = new LoginResVo();
            loginResponseDto.setUserid(userBean.getUserid());
            loginResponseDto.setToken(token);
            return loginResponseDto;
        }catch (Exception e){
            log.error("生成jwt-token失败");
            LoginResVo loginResponseDto = new LoginResVo();
            loginResponseDto.setToken("fail");
            return loginResponseDto;
        }
    }
}
