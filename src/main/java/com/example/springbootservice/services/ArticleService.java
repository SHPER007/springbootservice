package com.example.springbootservice.services;

import com.example.springbootservice.domain.params.ArticlePageParam;
import com.example.springbootservice.domain.params.ArticleParam;
import com.example.springbootservice.domain.po.Articles;
import com.example.springbootservice.domain.responsevo.ArticlesCategoryResDto;
import com.example.springbootservice.domain.responsevo.PublicPageDto;
import com.example.springbootservice.domain.responsevo.UserArticlesResDto;

/**
 * ClassName:ArticleService
 * Description:TODO
 * Author:SunHang
 * Date:2024/7/31 22:13
 */
public interface ArticleService {

    UserArticlesResDto getUserArticlesByUserId();

    PublicPageDto<Articles> getPublicArticlesList(ArticlePageParam articlePageParam);

    ArticlesCategoryResDto getArticlesCategory();

    Boolean createArticle(ArticleParam articleParam);
}
