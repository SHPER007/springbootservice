package com.example.springbootservice.conf.enums;

import lombok.Getter;

/**
 * ClassName:ArticleIsPublicEnum
 * Description:TODO
 * Author:SunHang
 * Date:2024/8/10 22:15
 */
@Getter
public enum ArticleIsPublicEnum {
    ARTICLE_PUBLIC(1, "公共文章");
    // 跟数据库类型保持映射
    private final int value;
    // 标注那个类型返回给气前端
    private final String category;

    ArticleIsPublicEnum(int value, String category) {
        this.value = value;
        this.category = category;

    }
}
