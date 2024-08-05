package com.example.springbootservice.domain.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName:ArticlesFavorites
 * Description:TODO
 * Author:SunHang
 * Date:2024/8/5 22:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("articles_favorites")
public class ArticlesFavorites {
    private Integer id;
    @TableField("user_id")
    private Integer userId;
    @TableField("article_id")
    private Integer articleId;
    // @TableField("created_at")
    // private ZonedDateTime createdAt;
}
