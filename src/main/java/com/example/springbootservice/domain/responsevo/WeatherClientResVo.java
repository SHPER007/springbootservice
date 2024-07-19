package com.example.springbootservice.domain.responsevo;

import lombok.Data;

import java.util.List;

/**
 * ClassName:WeatherClientResDto
 * Description: 天气情况实体类
 * Author:SunHang
 * Date:2024/6/23 16:56
 */
@Data
public class WeatherClientResVo {
    private String status;
    private String count;
    private String info;
    private String infocode;
    private List<LiveWeatherVo> lives;

}
