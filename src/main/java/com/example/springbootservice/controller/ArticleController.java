package com.example.springbootservice.controller;

import com.example.springbootservice.conf.enums.ResponseCode;
import com.example.springbootservice.domain.baseresponse.BaseResponseResult;
import com.example.springbootservice.domain.params.ArticlePageParam;
import com.example.springbootservice.domain.params.ArticleParam;
import com.example.springbootservice.domain.po.Articles;
import com.example.springbootservice.domain.responsevo.ArticlesCategoryResDto;
import com.example.springbootservice.domain.responsevo.PublicPageDto;
import com.example.springbootservice.domain.responsevo.UserArticlesResDto;
import com.example.springbootservice.services.ArticleService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName:ArticleController
 * Description:TODO
 * Author:SunHang
 * Date:2024/7/31 22:12
 */
@Slf4j
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @GetMapping("/all/list")
    public BaseResponseResult getUserArticlesByUserId() {
        UserArticlesResDto userArticlesResDto = articleService.getUserArticlesByUserId();
        if (userArticlesResDto == null) {
            return BaseResponseResult.fail(ResponseCode.ARTICLES_IS_NULL.getValue(), ResponseCode.ARTICLES_IS_NULL.getDescription());
        }
        return BaseResponseResult.success(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), userArticlesResDto);
    }
    @PostMapping("/create")
    public BaseResponseResult createArticle(@RequestBody ArticleParam articleParam){
        Boolean isCreateArticleSuccess = articleService.createArticle(articleParam);
        if (!isCreateArticleSuccess) {
            return BaseResponseResult.fail(ResponseCode.ARTICLES_CREATE_FAIL.getValue(), ResponseCode.ARTICLES_CREATE_FAIL.getDescription());
        }
        return BaseResponseResult.success(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());

    }

    @GetMapping("/category")
    public BaseResponseResult getUserArticlesByCategory() {
        ArticlesCategoryResDto articlesCategoryResDto = articleService.getArticlesCategory();
        if (articlesCategoryResDto == null) {
            return BaseResponseResult.fail(ResponseCode.ARTICLES_CATEGORY_IS_NULL.getValue(), ResponseCode.ARTICLES_CATEGORY_IS_NULL.getDescription());
        }
        return BaseResponseResult.success(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), articlesCategoryResDto);

    }

    /**
     * Params:[articlePageParam]
     * Return:com.example.springbootservice.domain.baseresponse.BaseResponseResult
     * Description: 公共文章接口传入 不同的参数查询不同的文章列表
     */
    @PostMapping("/public/list")
    public BaseResponseResult getPublicArticlesPage(@RequestBody ArticlePageParam articlePageParam) {
        PublicPageDto<Articles> publicPageDto = articleService.getPublicArticlesList(articlePageParam);
        if (publicPageDto == null || publicPageDto.getData().isEmpty()) {
            return BaseResponseResult.fail(ResponseCode.ARTICLES_IS_NULL.getValue(), ResponseCode.ARTICLES_IS_NULL.getDescription());
        }
        return BaseResponseResult.success(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), publicPageDto);
    }

    @PostMapping("/personal/list")
    public BaseResponseResult getUserArticlesList(@RequestBody ArticlePageParam articlePageParam) {
        return getPublicArticlesPage(articlePageParam);
    }

    @PostMapping("/approved/list")
    public BaseResponseResult getApproveArticlesList(@RequestBody ArticlePageParam articlePageParam) {
        return getPublicArticlesPage(articlePageParam);
    }
}
