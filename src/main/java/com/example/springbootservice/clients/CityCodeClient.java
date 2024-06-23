//package com.example.springbootservice.clients;
//
//import com.example.springbootservice.resdto.GeoResDto;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
///**
// * ClassName:CityCodeClient
// * Description:TODO
// * Author:SunHang
// * Date:2024/6/23 17:15
// */
//@FeignClient("citycodeservice")
//public interface CityCodeClient {
//    @GetMapping("/geocode/geo")
//    GeoResDto getCityGeoCodeByAddress(@RequestParam("address") String address, @RequestParam("key") String userKey);
//
//}
