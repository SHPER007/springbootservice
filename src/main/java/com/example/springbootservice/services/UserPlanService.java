package com.example.springbootservice.services;

import com.example.springbootservice.paramdto.UserPlanDtoParam;
import com.example.springbootservice.resdto.UserPlanDto;

/**
 * ClassName:UserPlanService
 * Description:TODO
 * Author:SunHang
 * Date:2024/7/7 17:45
 */
public interface UserPlanService {
    UserPlanDto getUserPlan(Integer userid);
    Boolean addUserPlan(UserPlanDtoParam userPlanDtoParam);
}
