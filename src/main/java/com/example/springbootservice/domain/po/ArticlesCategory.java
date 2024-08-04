package com.example.springbootservice.domain.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName:ArticlesCategory
 * Description:TODO
 * Author:SunHang
 * Date:2024/8/3 17:54
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("articles_category")
public class ArticlesCategory {
    private Integer id;
    private String category;
}
