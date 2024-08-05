package com.example.springbootservice.conf.enums;


import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum ArticleCateGoryEnum {
    // ALL_ARTICLES_CATEGORY(1, "全部文章"),
    EMOTION_ARTICLES_CATEGORY(2,"情感文章"),
    LIFE_ARTICLES_CATEGORY(3, "生活文章"),
    FINANCE_ARTICLES_CATEGORY(4, "财务文章"),
    THINK_ARTICLES_CATEGORY(5, "感悟文章"),
    OTHER_ARTICLES_CATEGORY(6, "其他文章");
    // 跟数据库类型保持映射
    @EnumValue
    private final int value;
    // 标注那个类型返回给气前端
    @JsonValue
    private final String category;

    ArticleCateGoryEnum(int value, String category) {
        this.value = value;
        this.category = category;

    }

}
