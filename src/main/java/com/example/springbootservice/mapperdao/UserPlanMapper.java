package com.example.springbootservice.mapperdao;

import com.example.springbootservice.mysqlbean.UserPlan;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ClassName:UserPlanMapper
 * Description:TODO
 * Author:SunHang
 * Date:2024/7/7 18:07
 */
@Mapper
@Repository
public interface UserPlanMapper {

    List<UserPlan> getUserPlanList(Integer userId);
}
