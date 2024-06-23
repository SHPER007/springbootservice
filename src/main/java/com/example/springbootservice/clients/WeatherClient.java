//package com.example.springbootservice.clients;
//
//import com.example.springbootservice.resdto.WeatherClientResDto;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
///**
// * ClassName:WeatherClient
// * Description:TODO
// * Author:SunHang
// * Date:2024/6/23 16:36
// */
//@FeignClient("weatherservice")
//public interface WeatherClient {
//    @GetMapping("/weather/weatherInfo")
//    WeatherClientResDto getWeatherByCityCode(@RequestParam("city") String city, @RequestParam("key") String userKey);
//}
