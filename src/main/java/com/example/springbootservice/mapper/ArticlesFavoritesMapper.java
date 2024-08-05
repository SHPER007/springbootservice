package com.example.springbootservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootservice.domain.po.ArticlesFavorites;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * ClassName:ArticlesFavoritesMapper
 * Description:TODO
 * Author:SunHang
 * Date:2024/8/5 22:15
 */
@Mapper
@Repository
public interface ArticlesFavoritesMapper extends BaseMapper<ArticlesFavorites> {

}
