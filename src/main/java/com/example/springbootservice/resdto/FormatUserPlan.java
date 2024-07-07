package com.example.springbootservice.resdto;

import lombok.Data;

/**
 * ClassName:FormatUserPlan
 * Description:TODO
 * Author:SunHang
 * Date:2024/7/8 00:01
 */
@Data
public class FormatUserPlan {
    private int id;
    private String planName;
    private String startTime;
    private Long endTime;
    private String location;
    private Long createdAt;
}
