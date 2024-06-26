package com.example.springbootservice.paramdto;

import lombok.Data;

/**
 * ClassName:LoginRequestDtoParam
 * Description: 用户登录请求入参
 * Author:SunHang
 * Date:2024/6/16 15:01
 */
@Data
public class LoginRequestDtoParam {
    private Integer userid;
    private String password;
}
