package com.example.springbootservice.domain.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName:UserPlan
 * Description:TODO
 * Author:SunHang
 * Date:2024/7/7 17:47
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPlan {
    private Integer id;
    private String planName;
    private String startTime;
    private String endTime;
    private String location;
    private String createdAt;

}
