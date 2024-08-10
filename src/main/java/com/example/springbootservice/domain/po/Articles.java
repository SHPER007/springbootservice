package com.example.springbootservice.domain.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.example.springbootservice.conf.enums.ArticleCateGoryEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName:Articles
 * Description:TODO
 * Author:SunHang
 * Date:2024/7/31 21:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Articles {
    private Integer id;
    private Integer userid;
    @TableField("category_id")
    private ArticleCateGoryEnum articleCateGory;
    private String author;
    private String title;
    private String content;
    private String weather;
    private String createPlace;
    @TableField("is_public")
    private Boolean isPublic;
    @TableField("is_approved")
    private Boolean isApproved;
    @TableField("update_time")
    private String updateTime;
    @TableField("create_time")
    private String creatTime;

}
