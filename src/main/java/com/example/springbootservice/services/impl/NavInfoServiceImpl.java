package com.example.springbootservice.services.impl;

import com.example.springbootservice.conf.contants.NavDefaultCity;
import com.example.springbootservice.conf.contants.RedisExpire;
import com.example.springbootservice.conf.resfulapi.WeatherCityApi;
import com.example.springbootservice.conf.utils.RedisUtil;
import com.example.springbootservice.conf.utils.SubStringUtil;
import com.example.springbootservice.conf.utils.ThreadLocalUtil;
import com.example.springbootservice.domain.po.User;
import com.example.springbootservice.domain.responsevo.HeadInfoResDto;
import com.example.springbootservice.domain.responsevo.LiveWeatherVo;
import com.example.springbootservice.mapper.NavInfoMapper;
import com.example.springbootservice.mapper.UserMapper;
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

    @Resource
    RedisUtil redisUtil;

    @Override
    public HeadInfoResDto getHeadInfoByUserId() {
        User user = userMapper.getUserByIdWithRoles(ThreadLocalUtil.get());
        if(user == null){
            throw new RuntimeException("user not found");
        }
        HeadInfoResDto headInfoResDto = new HeadInfoResDto();
        headInfoResDto.setNickName(user.getNickName());
        String firstThreeStrCityName = SubStringUtil.getFirstThreeCharacters(user.getAddress());
        if(firstThreeStrCityName == null){
            // 如果没有城市数据 直接设置用户的默认城市名称
            headInfoResDto.setCity(NavDefaultCity.DEFAULT_CITY);
            Object redisWeatherResult = redisUtil.get(NavDefaultCity.LIVE_WHEATHER_KEY);
            if(redisWeatherResult != null){
                headInfoResDto.setLiveWeatherRes((LiveWeatherVo)redisWeatherResult);
            }else {
                LiveWeatherVo liveWeatherVo = WeatherCityApi.getCityWeatherByAdCode(NavDefaultCity.DEFAULT_CITY_AD_CODE, restTemplate);
                headInfoResDto = setCityWeather(headInfoResDto, liveWeatherVo);
            }
        }else {
            headInfoResDto.setCity(firstThreeStrCityName);
            // 先从缓存取数据
            Object weatherResultCache = redisUtil.getJavaBean(NavDefaultCity.LIVE_WHEATHER_KEY, LiveWeatherVo.class);
            if(weatherResultCache != null){
                // 手动转redis对象数据
                log.info("cache+redisWeatherResult:{}", weatherResultCache.getClass().getName());
                headInfoResDto.setLiveWeatherRes((LiveWeatherVo)weatherResultCache);
            }else {
                String cityAdCode = navInfoMapper.getCityAdCode(headInfoResDto.getCity());
                LiveWeatherVo liveWeatherVo = WeatherCityApi.getCityWeatherByAdCode(cityAdCode, restTemplate);
                headInfoResDto = setCityWeather(headInfoResDto, liveWeatherVo);
            }
        }
        //  设置当前时间
        headInfoResDto.setDate(LocalDate.now());
        headInfoResDto.setWelcome("你好好");
        return headInfoResDto;
    }

    /**
     *Params:[headInfoResVo]
     *Return:com.example.springbootservice.domain.responsevo.HeadInfoResVo
     *Description: 默认城市【郑州市】
     */
    public HeadInfoResDto setCityWeather(HeadInfoResDto headInfoResDto, LiveWeatherVo liveWeatherVo) {
        if (liveWeatherVo != null) {
            // 封装1个redis 手动解析方法
            redisUtil.setJavaBean(NavDefaultCity.LIVE_WHEATHER_KEY, liveWeatherVo, RedisExpire.CACHE_WEATHER_EXPIRE_TIME);
            headInfoResDto.setLiveWeatherRes(liveWeatherVo);
            return headInfoResDto;
        } else {
            LiveWeatherVo liveWeatherDto = new LiveWeatherVo();
            liveWeatherDto.setWeather(NavDefaultCity.DEFAULT_WEATHER);
            liveWeatherDto.setCity(NavDefaultCity.DEFAULT_WEATHER_TEMPERATURE);
            headInfoResDto.setLiveWeatherRes(liveWeatherDto);
            return headInfoResDto;
        }

    }
}
