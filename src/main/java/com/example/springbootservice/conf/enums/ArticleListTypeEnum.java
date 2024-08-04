package com.example.springbootservice.conf.enums;

import lombok.Getter;

/**
 * ClassName:ArticleListEnum
 * Description:TODO
 * Author:SunHang
 * Date:2024/8/5 00:49
 */
@Getter
public enum ArticleListTypeEnum {
    PUBLIC_ARTICLES(0, "公共文章"),
    PERSONAL_ARTICLES(1, "个人文章"),
    APPROVE_ARTICLES(2, "审核文章");
    private final int value;
    private final String description;
    ArticleListTypeEnum(int value, String description) {
        this.value = value;
        this.description = description;

    }
}
