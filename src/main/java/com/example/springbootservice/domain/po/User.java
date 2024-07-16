package com.example.springbootservice.domain.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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

    @TableId("userid")
    private Integer userid;

    @TableField(exist=false)
    private Integer age;

    @TableField("nickname")
    private String nickName;

    @TableField(exist=false)
    private String phoneNumber;

    private String address;

    @TableField(exist=false)
    private String password;

    private Set<Role> roles;

}
