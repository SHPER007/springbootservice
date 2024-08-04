package com.example.springbootservice.conf.enums;


import lombok.Getter;

@Getter
public enum ArticleCateGoryEnum {
    ALL_ARTICLES_CATEGORY(1, "全部文章"),
    EMOTION_ARTICLES_CATEGORY(2,"情感文章"),
    LIFE_ARTICLES_CATEGORY(3, "生活文章"),
    FINANCE_ARTICLES_CATEGORY(4, "财务文章"),
    THINK_ARTICLES_CATEGORY(5, "规则文章"),
    OTHER_ARTICLES_CATEGORY(5, "其他文章");
    private final int value;
    private final String category;

    ArticleCateGoryEnum(int value, String category) {
        this.value = value;
        this.category = category;

    }

}
