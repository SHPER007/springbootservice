package com.example.springbootservice.controller;

import com.example.springbootservice.conf.enums.ResponseCode;
import com.example.springbootservice.domain.params.UserPlanDtoParam;
import com.example.springbootservice.domain.responsevo.UserPlanDtoVo;
import com.example.springbootservice.domain.baseresponse.BaseResponseResult;
import com.example.springbootservice.services.UserPlanService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName:UserPlanInfo
 * Description:用户日程计划管理类
 * Author:SunHang
 * Date:2024/7/7 17:34
 */
@RestController
@Slf4j
@RequestMapping("/userplan")
public class UserPlanController {
    @Resource
    private UserPlanService userPlanService;

    @GetMapping()
    public BaseResponseResult getUserPlan() {
        UserPlanDtoVo userPlanDtoVo = userPlanService.getUserPlan();
        if (userPlanDtoVo == null) {
            return BaseResponseResult.fail(ResponseCode.USER_DATA_IS_NULL.getValue(),ResponseCode.USER_DATA_IS_NULL.getDescription());
        }
        return BaseResponseResult.success(HttpStatus.OK.value(), "200", userPlanDtoVo);
    }

    @PostMapping("/creat")
    public BaseResponseResult addUserPlan(@RequestBody UserPlanDtoParam userPlanDtoParam) {
        Boolean addUserPlanResult = userPlanService.addUserPlan(userPlanDtoParam);
        if (addUserPlanResult) {
            return BaseResponseResult.success(HttpStatus.OK.value(), "200");
        }else {
            return BaseResponseResult.fail(ResponseCode.USER_DATA_IS_NULL.getValue(),"200");
        }
    }

}
