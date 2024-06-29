package com.example.springbootservice.restemplateApi;

import com.example.springbootservice.conf.contants.WeatherBaseURL;
import com.example.springbootservice.resdto.LiveWeatheResDto;
import com.example.springbootservice.resdto.WeatherClientResDto;
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

    public static String getCityWeatherByAdCode(String cityAdCode, RestTemplate restTemplate){
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(WeatherBaseURL.WEATHER_URL)
                .queryParam("city", cityAdCode).queryParam("key", WeatherBaseURL.WEATHER_KEY);
        try {
            String weatherApiUrl = uriComponentsBuilder.toUriString();
            log.info("请求的天气url地址为: {}", weatherApiUrl);
            ResponseEntity<WeatherClientResDto> forEntity = restTemplate.getForEntity(weatherApiUrl, WeatherClientResDto.class);
            WeatherClientResDto weatherClientResDto = forEntity.getBody();
            if(weatherClientResDto != null && weatherClientResDto.getStatus().equals("1")){
                List<LiveWeatheResDto> listWeatherResDto = weatherClientResDto.getLives();
                String weather = "";
                for (LiveWeatheResDto liveWeatheResDto : listWeatherResDto) {
                     weather = liveWeatheResDto.getWeather();
                }
                return weather;
            }

        }catch (Exception e){
            log.info("weather api exception{}", e.getMessage());
            return "你若安好，便是晴天";
        }
        log.info("weather api not response ");
        return "你若安好，便是晴天";
    }

}
