package com.example.springbootservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootservice.domain.po.ArticlesCategory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * ClassName:ArticlesCategroyMapper
 * Description:TODO
 * Author:SunHang
 * Date:2024/8/3 18:04
 */
@Mapper
@Repository
public interface ArticlesCategoryMapper extends BaseMapper<ArticlesCategory> {
}

