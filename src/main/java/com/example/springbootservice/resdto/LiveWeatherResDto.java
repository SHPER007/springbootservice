package com.example.springbootservice.resdto;

import lombok.Data;

/**
 * ClassName:LiveWeather
 * Description:TODO
 * Author:SunHang
 * Date:2024/6/23 17:03
 */
@Data
public class LiveWeatherResDto {
        private String province;
        private String city;
        private String adcode;
        private String weather;
        private String temperature;
        private String winddirection;
        private String windpower;
        private String humidity;
        private String reporttime;
        private float temperature_float;
        private float humidity_float;
}
