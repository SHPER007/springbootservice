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
    private String title;
    private String author;
    private List<String> date;
}
