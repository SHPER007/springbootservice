package com.example.springbootservice.domain.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName:Cities
 * Description:TODO
 * Author:SunHang
 * Date:2024/7/17 00:16
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("cities")
public class Cities {
    private Integer id;
    private String adcode;
    private String cityName;
    private String cityCode;
}
