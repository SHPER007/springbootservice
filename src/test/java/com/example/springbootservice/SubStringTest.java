package com.example.springbootservice;

import com.example.springbootservice.conf.utils.SubStringUtil;
import com.example.springbootservice.conf.utils.SuperLanguage;
import com.example.springbootservice.resdto.HeadInfoResDto;
import com.example.springbootservice.services.impl.NavInfoServiceImpl;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName:SubStringTest
 * Description:TODO
 * Author:SunHang
 * Date:2024/6/23 14:36
 */
@SpringBootTest
public class SubStringTest{

    @Resource
    RestTemplate restTemplate;

    @Resource
    NavInfoServiceImpl navInfoService;

    @Test
   public void subStringTest(){
        String s = "";
        String sw = SubStringUtil.getFirstThreeCharacters(s);
        System.out.println(sw);

    }
    @Test
    public void CityCodeClient(){
//        String adCodeUrl = WeatherUrlUtil.getCityAdCodeUrl("郑州市金水区", WeatherBaseURL.WEATHER_KEY);
//        System.out.println(adCodeUrl);
//        String adCodeUrl1 = "https://restapi.amap.com/v3/geocode/geo?city=郑州&address=%E9%83%91%E5%B7%9E%E5%B8%82%E9%87%91%E6%B0%B4%E5%8C%BA&key=9d8070fdb0397581fe62ec0b5b5cec29";
//        ResponseEntity<String> forEntity = restTemplate.getForEntity(adCodeUrl1, String.class);
//        String body = forEntity.getBody();
//        System.out.println(body);
//        String adCodeUrl = CityWeatherApi.getWeatherUrl("110101", WeatherBaseURL.WEATHER_KEY);
//        System.out.println(adCodeUrl);
//        ResponseEntity<WeatherClientResDto> forEntity = restTemplate.getForEntity(adCodeUrl, WeatherClientResDto.class);
//        WeatherClientResDto body = forEntity.getBody();
//        System.out.println(body);

    }
    @Test
    public void testNumber(){
        String superLanguage = SuperLanguage.getSuperLanguage();
        System.out.println(superLanguage);
    }


    @Test
    public void testSubString(){
        HeadInfoResDto headInfoByUserId = navInfoService.getHeadInfoByUserId(Integer.valueOf("10010"));
    }
}
