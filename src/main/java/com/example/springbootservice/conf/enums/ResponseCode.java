package com.example.springbootservice.conf.enums;

public enum ResponseCode {
    DELETE_SOURCE_FAILED(30005,"resource no found "),
    USER_DATA_IS_NULL(30000, "用户计划数据为空"),
    ARTICLES_IS_NULL(30001, "用户文章数据为空"),
    INSUFFICIENT_PERMISSIONS(40301, "权限不足"),
    ARTICLES_CATEGORY_IS_NULL(30000,"文章分类数据为空");


    private final int value;
    private final String description;
    ResponseCode(int value, String description) {
        this.value = value;
        this.description = description;
    }
    public int getValue() {
        return value;
    }
    public String getDescription() {
        return description;
    }

}
