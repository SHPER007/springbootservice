package com.example.springbootservice.services.impl;

import com.example.springbootservice.conf.contants.NavDefaultCity;
import com.example.springbootservice.conf.utils.SubStringUtil;
import com.example.springbootservice.conf.utils.SuperLanguage;
import com.example.springbootservice.mapperdao.NavInfoMapper;
import com.example.springbootservice.mapperdao.UserMapper;
import com.example.springbootservice.mysqlbean.User;
import com.example.springbootservice.resdto.HeadInfoResDto;
import com.example.springbootservice.restemplateApi.WeatherCityApi;
import com.example.springbootservice.services.NavInfoService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

/**
 * ClassName:NavHeadInfoServiceImpl
 * Description:TODO
 * Author:SunHang
 * Date:2024/6/23 14:12
 */
@Slf4j
@Service
public class NavInfoServiceImpl implements NavInfoService {
    @Resource
    NavInfoMapper navInfoMapper;
    @Resource
    RestTemplate restTemplate;
    @Resource
    UserMapper userMapper;
    @Override
    public HeadInfoResDto getHeadInfoByUserId(Integer userid) {
        User user = userMapper.getUserByIdWithRoles(userid);
        log.info(user.toString());
        HeadInfoResDto headInfoResponseDto = new HeadInfoResDto();
        headInfoResponseDto.setNickName(user.getNickName());
        String firstThreeStrCityName = SubStringUtil.getFirstThreeCharacters(user.getAddress());
        if (firstThreeStrCityName != null) {
            headInfoResponseDto.setCity(firstThreeStrCityName);
            String cityAdCode = navInfoMapper.getCityAdCode(headInfoResponseDto.getCity());
            String weather = WeatherCityApi.getCityWeatherByAdCode(cityAdCode, restTemplate);
            headInfoResponseDto.setWeather(weather);
        }else {
            // 如果没有数据设置用户的默认城市名称
            headInfoResponseDto.setCity(NavDefaultCity.DEFAULT_CITY);
            String weather = WeatherCityApi.getCityWeatherByAdCode(NavDefaultCity.DEFAULT_CITY_AD_CODE, restTemplate);
            headInfoResponseDto.setWeather(weather);
        }
        //  设置当前时间
        headInfoResponseDto.setData(LocalDate.now());
        headInfoResponseDto.setWelcome(SuperLanguage.getSuperLanguage());
        return headInfoResponseDto;


        //利用Feign远程调用
        //headInfoResponseDto.setWelcome();

    }
}
