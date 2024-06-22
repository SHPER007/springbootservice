package com.example.springbootservice.mysqlbean;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    public User(Integer id,String nickName){
        this.userid = id;
        this.nickName = nickName;
    }
    private Integer userid;
    @JsonIgnore
    private Integer age;
    private String nickName;
    @JsonIgnore
    private String phoneNumber;
    private String address;
    @JsonIgnore
    private String password;
    private Set<Role> roles;

}
