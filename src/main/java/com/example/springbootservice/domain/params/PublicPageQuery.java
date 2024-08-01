package com.example.springbootservice.domain.params;
import lombok.Data;

/**
 *Params:
 *Return:
 *Description: 公共分页查询实体
 */
@Data
public class PublicPageQuery{
    private Integer pageNo;
    private Integer pageSize;
    // 枚举类 按照什么排序  0 按照创建时间 1 按照更新时间
    private Integer orderBy;
    private Boolean isAsc;

}
