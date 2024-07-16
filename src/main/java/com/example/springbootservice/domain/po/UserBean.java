package com.example.springbootservice.domain.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * ClassName:UserBean
 * Description:TODO
 * Author:SunHang
 * Date:2024/7/17 02:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBean {
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

}
