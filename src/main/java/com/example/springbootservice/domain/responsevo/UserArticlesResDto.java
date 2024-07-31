package com.example.springbootservice.domain.responsevo;

import com.example.springbootservice.domain.po.Articles;
import lombok.Data;

import java.util.List;

/**
 * ClassName:UserArticlesResDto
 * Description:TODO
 * Author:SunHang
 * Date:2024/7/31 21:58
 */
@Data
public class UserArticlesResDto {
    private List<Articles> ArticlesLists;
}
