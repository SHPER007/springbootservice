package com.example.springbootservice.domain.params;

import lombok.Data;

/**
 * ClassName:ArticleParam
 * Description:TODO
 * Author:SunHang
 * Date:2024/8/10 21:04
 */
@Data
public class ArticleParam {
    // 文章id 更新的时候用
    private Integer articleId;
    // 文章标题
    private String title;
    // 文章内容
    private String content;
    // getArticleCateGory
    private Integer articleCateGory;
    // 天气
    private String weather;
    // 地点
    private String createPlace;
    // 是否上架到公共列表 0 表示否  1 表示是
    private Boolean isPublic;

}

