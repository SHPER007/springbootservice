package com.example.springbootservice.resdto;

import lombok.Data;

import java.util.List;

/**
 * ClassName:WeatherClientResDto
 * Description: 天气情况实体类
 * Author:SunHang
 * Date:2024/6/23 16:56
 */
@Data
public class WeatherClientResDto {
    private String status;
    private String count;
    private String info;
    private String infocode;
    private List<LiveWeatherResDto> lives;

}
