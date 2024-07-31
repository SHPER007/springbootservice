package com.example.springbootservice.domain.params;

import lombok.Data;

import java.time.OffsetDateTime;

/**
 * ClassName:UserplanDto
 * Description:TODO
 * Author:SunHang
 * Date:2024/7/9 00:26
 */
@Data
public class UserPlanParam {
    private String planName;
    private OffsetDateTime planDate;
    private String startTime;
    private String endTime;
    private String location;

}
