package com.example.springbootservice.conf.resfulapi;

import com.example.springbootservice.conf.contants.WeatherBaseURL;
import com.example.springbootservice.domain.responsevo.LiveWeatherVo;
import com.example.springbootservice.domain.responsevo.WeatherClientResVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;


/**
 * ClassName:WeathUrlUtil
 * Description:根据cityAdCode查询天气
 * Author:SunHang
 * Date:2024/6/23 18:46
 */
@Slf4j
public class WeatherCityApi {

    public static LiveWeatherVo getCityWeatherByAdCode(String cityAdCode, RestTemplate restTemplate){
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(WeatherBaseURL.WEATHER_URL)
                .queryParam("city", cityAdCode).queryParam("key", WeatherBaseURL.WEATHER_KEY);
        try {
            String weatherApiUrl = uriComponentsBuilder.toUriString();
            ResponseEntity<WeatherClientResVo> forEntity = restTemplate.getForEntity(weatherApiUrl, WeatherClientResVo.class);
            WeatherClientResVo weatherClientResVo = forEntity.getBody();
            if(weatherClientResVo != null && weatherClientResVo.getStatus().equals("1")){
                List<LiveWeatherVo> listWeatherResDto = weatherClientResVo.getLives();
                String weather = "";
                for (LiveWeatherVo liveWeatherVo : listWeatherResDto) {
                    return liveWeatherVo;
                }
            }
            return null;
        }catch (Exception e){
            log.info("weather api exception{}", e.getMessage());
            return null;
        }
    }

}
