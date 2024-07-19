package com.example.springbootservice.domain.responsevo;

import com.example.springbootservice.domain.po.UserPlan;
import lombok.Data;

import java.util.List;

/**
 * ClassName:UserPlanDto
 * Description:TODO
 * Author:SunHang
 * Date:2024/7/7 18:03
 */
@Data
public class UserPlanResDto {
    private String chinese;
    private String english;
    private List<UserPlan> listPlan;
}
