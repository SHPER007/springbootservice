package com.example.springbootservice.controller;

import com.example.springbootservice.conf.enums.ResponseCode;
import com.example.springbootservice.domain.baseresponse.BaseResponseResult;
import com.example.springbootservice.domain.params.ArticlePageParam;
import com.example.springbootservice.domain.po.Articles;
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
    @GetMapping("/list")
    public BaseResponseResult getUserArticlesByUserId() {
        UserArticlesResDto userArticlesResDto = articleService.getUserArticlesByUserId();
        if (userArticlesResDto == null) {
            return BaseResponseResult.fail(ResponseCode.USER_ARTICLES_IS_NULL.getValue(),ResponseCode.USER_ARTICLES_IS_NULL.getDescription());
        }
        return BaseResponseResult.success(HttpStatus.OK.value(),HttpStatus.OK.getReasonPhrase(),userArticlesResDto);
    }

    @PostMapping("/page")
    public BaseResponseResult getUserArticlesPage(@RequestBody ArticlePageParam articlePageParam){
        PublicPageDto<Articles> publicPageDto =  articleService.getUserArticlesPage(articlePageParam);
        if (publicPageDto == null || publicPageDto.getData().isEmpty()) {
            return BaseResponseResult.fail(ResponseCode.USER_ARTICLES_IS_NULL.getValue(),ResponseCode.USER_ARTICLES_IS_NULL.getDescription());
        }
        return BaseResponseResult.success(HttpStatus.OK.value(),HttpStatus.OK.getReasonPhrase(),publicPageDto);
    }

}
