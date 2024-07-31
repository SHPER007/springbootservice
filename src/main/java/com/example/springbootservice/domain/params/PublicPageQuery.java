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
    private String orderBy;
    private Boolean isAsc;

}
