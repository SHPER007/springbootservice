package com.example.springbootservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootservice.domain.po.Cities;
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
public interface NavInfoMapper extends BaseMapper<Cities> {
    /**
    *Params:cityName
    *Return: cityAdCode
    *Description: 根据城市名称查询 城市adcode
    */

    String getCityAdCode(String cityName);
}
