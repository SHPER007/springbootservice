package com.example.springbootservice.services;

import com.example.springbootservice.mysqlbean.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:UserService
 * Package:com.example.springbootservice.services
 * Description:TODO
 * Date:2024/3/31 0031 18:03
 * Author:2498897200@qq.com
 */

public interface UserService {

    User getUserById(Integer userId);
    /**
    *Description:查询所有
    */
    List<User> userList();
    List<User> pageUserList();



}
