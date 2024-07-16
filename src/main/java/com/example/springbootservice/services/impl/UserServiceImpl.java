package com.example.springbootservice.services.impl;

import com.example.springbootservice.conf.utils.ThreadLocalUtil;
import com.example.springbootservice.mapper.UserMapper;
import com.example.springbootservice.domain.po.User;
import com.example.springbootservice.services.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * ClassName:UserServiceImpl
 * Package:com.example.springbootservice.services.impl
 * Description:TODO
 * Date:2024/3/31 0031 18:45
 * Author:2498897200@qq.com
 */

@Service
public class UserServiceImpl implements UserService{

    @Resource
    UserMapper userMapper;

    @Override
    public User getUserByIdWithRoles() {
        Integer userId = ThreadLocalUtil.get();
        return userMapper.getUserByIdWithRoles(userId);
    }
}
