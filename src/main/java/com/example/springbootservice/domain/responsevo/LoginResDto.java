package com.example.springbootservice.domain.responsevo;

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
public class LoginResDto {
    private Integer userid;
    private String token;

}
