package com.example.springbootservice.domain.params;

import lombok.Data;

import java.util.List;

/**
 * ClassName:ArticlieListParam
 * Description:TODO
 * Author:SunHang
 * Date:2024/8/1 00:42
 */
@Data
public class ArticlePageParam extends PublicPageQuery {
    // 0 公共文章  1 私有文章 2 待审核
    private Integer  articleListType;
    // 每个文章列表查询类型 默认查询每个列表的全部数据 一共支持6类文章
    private Integer  articleClassify;
    private String title;
    private String author;
    private List<String> date;
}
