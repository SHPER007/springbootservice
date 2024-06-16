package com.example.springbootservice.mysqlbean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName:Role
 * Description:TODO
 * Author:SunHang
 * Date:2024/6/16 18:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private Integer id;
    private String role;
}
