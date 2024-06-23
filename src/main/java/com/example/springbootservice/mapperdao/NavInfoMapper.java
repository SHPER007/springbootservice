package com.example.springbootservice.mapperdao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * ClassName:NavInfoMapper
 * Description:TODO
 * Author:SunHang
 * Date:2024/6/23 23:01
 */
@Mapper
@Repository
public interface NavInfoMapper {
    /**
    *Params:cityName
    *Return: cityAdCode
    *Description: 根据城市名称查询 城市adcode
    */
    String getCityAdCode(String cityName);
}
