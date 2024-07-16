package com.example.springbootservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootservice.domain.po.UserPlan;
import com.example.springbootservice.domain.po.UserPlanBean;
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
public interface UserPlanMapper extends BaseMapper<UserPlan> {

    List<UserPlan> getUserPlanList(Integer userId);
    int addUserPlan(UserPlanBean userPlan);
}
