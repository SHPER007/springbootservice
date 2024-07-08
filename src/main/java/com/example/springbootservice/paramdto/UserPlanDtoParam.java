package com.example.springbootservice.paramdto;

import lombok.Data;

import java.time.OffsetDateTime;

/**
 * ClassName:UserplanDto
 * Description:TODO
 * Author:SunHang
 * Date:2024/7/9 00:26
 */
@Data
public class UserPlanDtoParam {
    private String planName;
    private OffsetDateTime planDate;
    private String startTime;
    private String endTime;
    private String location;

}
