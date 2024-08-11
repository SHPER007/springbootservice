package com.example.springbootservice.domain.responsevo;

import lombok.Data;

/**
 * ClassName:ArtcilesDetailResDto
 * Description:TODO
 * Author:SunHang
 * Date:2024/8/11 17:48
 */
@Data
public class ArticlesDetailResDto {
    // 文章标题
    private String title;
    // 文章内容
    private String content;
    // 文章分类
    private String articleCateGory;
    // 天气
    private String weather;
    // 地点
    private String createPlace;
    // 是否上架到公共列表 0 表示否  1 表示是
    private Boolean isPublic;
}
