package com.example.springbootservice.domain.responsevo;

import lombok.Data;

import java.time.LocalDate;

/**
 * ClassName:HeadInfoResponseDto
 * Description:TODO
 * Author:SunHang
 * Date:2024/6/23 14:14
 */
@Data
public class HeadInfoResDto {
    private String city;
    private String nickName;
    private LiveWeatherVo liveWeatherRes;
    private String welcome;
    private LocalDate date;
}
