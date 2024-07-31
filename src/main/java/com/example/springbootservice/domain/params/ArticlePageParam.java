package com.example.springbootservice.domain.params;

import lombok.Data;

/**
 * ClassName:ArticlieListParam
 * Description:TODO
 * Author:SunHang
 * Date:2024/8/1 00:42
 */
@Data
public class ArticlePageParam extends PublicPageQuery {

    private Long date;
    private String title;
    private String author;
    /**
     * 排序方式 0 正序  1 倒叙
     */
    private Integer sortOrder;

}
