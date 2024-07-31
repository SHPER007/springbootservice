package com.example.springbootservice.services.impl;

import com.example.springbootservice.domain.params.ArticlePageParam;
import com.example.springbootservice.domain.po.Articles;
import com.example.springbootservice.domain.responsevo.PublicPageDto;
import com.example.springbootservice.services.ArticleService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ArticleServiceImplTest {

    @Resource
    private ArticleService articleService;
    @Test
    void test(){
        ArticlePageParam articlePageParam = new ArticlePageParam();
        articlePageParam.setPageNo(1);
        articlePageParam.setPageSize(2);
        articlePageParam.setAuthor("Admin");
        PublicPageDto<Articles> userArticlesPage = articleService.getUserArticlesPage(articlePageParam);
        System.out.println("当前页"+ userArticlesPage.getPages());
        System.out.println("总数"+ userArticlesPage.getTotal());
        userArticlesPage.getData().forEach(System.out::println);
    }

}