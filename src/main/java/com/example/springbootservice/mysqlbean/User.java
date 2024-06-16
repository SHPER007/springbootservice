package com.example.springbootservice.mysqlbean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * ClassName:User
 * Package:com.example.springbootservice.entity
 * Description:用户实体表
 * Date:2024/3/31 0031 17:48
 * Author:2498897200@qq.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private Integer age;
    private String nickName;
    private String phoneNumber;
    private String address;
    private String password;
    private Set<Role> roles;

}
