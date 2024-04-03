package com.example.springbootservice.paramdto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

/**
 * ClassName:User
 * Package:com.example.springbootservice.control
 * Description:TODO
 * Date:2024/3/30 0030 0:24
 * Author:2498897200@qq.com
 */

@Data
@Validated
public class UserDto {
    @NotBlank(message = "用户名称不能为空")
    private String name;

    @NotNull
    private Integer age;
}
