package com.example.springbootservice.mapperdao;

import com.example.springbootservice.mysqlbean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ClassName:UserMappers
 * Package:com.example.springbootservice.mappers
 * Description:TODO
 * Date:2024/3/31 0031 17:11
 * Author:2498897200@qq.com
 */

@Mapper
@Repository
public interface UserMapper {

    /**
     *Description:查询单个用户
     */
    User getUserByIdWithRoles(Integer userId);

    /**
     *Description:查询所有
     */
    List<User> userList();

    List<User> pageUserList();


}
