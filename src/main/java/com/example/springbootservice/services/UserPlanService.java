package com.example.springbootservice.services;

import com.example.springbootservice.domain.params.UserPlanDtoParam;
import com.example.springbootservice.domain.responsevo.UserPlanResDto;

/**
 * ClassName:UserPlanService
 * Description:TODO
 * Author:SunHang
 * Date:2024/7/7 17:45
 */
public interface UserPlanService {
    UserPlanResDto getUserPlan();
    Boolean createUserPlan(UserPlanDtoParam userPlanDtoParam);

    Boolean clearUserPlanForToday();
}
