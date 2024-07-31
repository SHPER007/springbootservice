package com.example.springbootservice.domain.responsevo;

import lombok.Data;

import java.util.List;

/**
 * ClassName:PublicPageDto
 * Description:TODO 公共分页结果返回部分
 * Author:SunHang
 * Date:2024/8/1 00:55
 */
@Data
public class PublicPageDto<T> {
    // 分页总条数
    private Long total;
    // 分页中页数
    private Long pages;
    // 分页数据
    private List<T> data;
}
