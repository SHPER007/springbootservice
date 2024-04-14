package com.example.springbootservice.mysqlbean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName:User
 * Package:com.example.springbootservice.entity
 * Description:TODO
 * Date:2024/3/31 0031 17:48
 * Author:2498897200@qq.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String nickName;
    private Integer age;
    private String phoneNumber;
    private String address;

}
