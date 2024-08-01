package com.example.springbootservice.conf.enums;

import lombok.Getter;

@Getter
public enum OrderByEnum {
    CREATE_TIME(0,"按照创建时间排序"),
    UPDATE_TIME(1,"按照更新时间排序");

    private final Integer value;
    private final String description;

    OrderByEnum(Integer value, String description) {
        this.value = value;
        this.description = description;
    }



}
