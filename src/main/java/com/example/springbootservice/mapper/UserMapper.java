package com.example.springbootservice.mapper;

import com.example.springbootservice.domain.po.User;
import com.example.springbootservice.domain.responsevo.UserArticlesResDto;
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
    List<User> getAllUserList();
    User getUserById(Integer userId);
    List<User> pageUserList();

    /**
     *Params:
     *Return:
     *Description: 查询用户所有的文章列表
     */

    UserArticlesResDto getUserArticlesById(Integer userId);


}
