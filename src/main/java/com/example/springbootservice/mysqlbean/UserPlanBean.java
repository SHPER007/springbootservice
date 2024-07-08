package com.example.springbootservice.mysqlbean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName:UserPlanBean
 * Description:TODO
 * Author:SunHang
 * Date:2024/7/9 01:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPlanBean {
        private Integer userid;
        private String planName;
        private Long startTime;
        private Long endTime;
        private String location;
        private Long createdAt;
}
