package com.example.springbootservice.conf.enums;

public enum ResponseCode {
    DELETE_SOURCE_FAILED(30005,"resource no found "),
    USER_DATA_IS_NULL(30000, "数据为空"),
    INSUFFICIENT_PERMISSIONS(40301, "权限不足");



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
