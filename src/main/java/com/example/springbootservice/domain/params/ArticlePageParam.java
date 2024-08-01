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

    private List<String> date;
    private String title;
    private String author;


}
