package com.example.springbootservice.services.impl;

import com.example.springbootservice.mapperdao.UserMapper;
import com.example.springbootservice.mysqlbean.User;
import com.example.springbootservice.services.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public User getUserByIdWithRoles(Integer userId) {
        return userMapper.getUserByIdWithRoles(userId);
    }

    @Override
    public List<User> userList() {
        return null;
    }

    @Override
    public List<User> pageUserList() {
        return null;
    }
}
