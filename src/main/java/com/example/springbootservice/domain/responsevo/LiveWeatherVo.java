package com.example.springbootservice.domain.responsevo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ClassName:LiveWeather
 * Description:TODO
 * Author:SunHang
 * Date:2024/6/23 17:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LiveWeatherVo implements Serializable {
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
