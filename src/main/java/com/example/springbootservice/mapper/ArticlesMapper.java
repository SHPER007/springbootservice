package com.example.springbootservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootservice.domain.po.Articles;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * ClassName:ArtclesMapper
 * Description:TODO
 * Author:SunHang
 * Date:2024/7/31 22:17
 */
@Mapper
@Repository
public interface ArticlesMapper extends BaseMapper<Articles> {

}
