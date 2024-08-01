package com.example.springbootservice.domain.po;

import com.baomidou.mybatisplus.annotation.TableField;
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
    private int userid;
    private String author;
    private String title;
    private String content;
    private String weather;
    @TableField("update_time")
    private String updateTime;
    @TableField("create_time")
    private String creatTime;

}
