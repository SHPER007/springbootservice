package com.example.springbootservice.resdto;

import com.example.springbootservice.mysqlbean.UserPlan;
import lombok.Data;

import java.util.List;

/**
 * ClassName:UserPlanDto
 * Description:TODO
 * Author:SunHang
 * Date:2024/7/7 18:03
 */
@Data
public class UserPlanDto {
    private String chinese;
    private String english;
    private List<UserPlan> userPlanDto;
}
