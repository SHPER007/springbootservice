package com.example.springbootservice.paramdto;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * ClassName:LoginResponseDto
 * Description:TODO
 * Author:SunHang
 * Date:2024/6/16 14:48
 */
@Data
@Component
public class LoginResponseDto {
    private Integer userid;
    private String token;

}
