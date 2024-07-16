package com.example.springbootservice.domain.po;

import com.baomidou.mybatisplus.annotation.TableId;
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
        @TableId("userid")
        private Integer userid;
        private String planName;
        private Long startTime;
        private Long endTime;
        private String location;
        private Long createdAt;
}
