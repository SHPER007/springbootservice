package com.example.springbootservice.domain.responsevo;

import com.example.springbootservice.domain.po.ArticlesCategory;
import lombok.Data;

import java.util.List;

/**
 * ClassName:ArticlesCategoryResDto
 * Description:TODO
 * Author:SunHang
 * Date:2024/8/3 17:59
 */
@Data
public class ArticlesCategoryResDto{
    List<ArticlesCategory> data;
}
