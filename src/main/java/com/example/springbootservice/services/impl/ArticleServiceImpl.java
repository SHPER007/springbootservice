package com.example.springbootservice.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootservice.domain.params.ArticlePageParam;
import com.example.springbootservice.domain.po.Articles;
import com.example.springbootservice.domain.responsevo.PublicPageDto;
import com.example.springbootservice.domain.responsevo.UserArticlesResDto;
import com.example.springbootservice.mapper.ArticlesMapper;
import com.example.springbootservice.services.ArticleService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:ArticleServiceImpl
 * Description:TODO
 * Author:SunHang
 * Date:2024/7/31 22:15
 */
@Slf4j
@Service
public class ArticleServiceImpl implements ArticleService {
    /**
     *Params:[]
     *Return:com.example.springbootservice.domain.responsevo.UserArticlesResDto
     *Description: 文章查询列表
     */
    @Resource
    ArticlesMapper articlesMapper;
    @Override
    public UserArticlesResDto getUserArticlesByUserId() {

        List<Articles> articlesList = articlesMapper.selectList(new QueryWrapper<Articles>().lambda().eq(Articles::getUserid, 10009));
        if (articlesList == null || articlesList.isEmpty()) {
            return null;
        }
        UserArticlesResDto userArticlesResDto = new UserArticlesResDto();
        userArticlesResDto.setArticlesLists(articlesList);
        return userArticlesResDto;
    }

    @Override
    public PublicPageDto<Articles> getUserArticlesPage(ArticlePageParam articlePageParam) {
        String author = articlePageParam.getAuthor();
        String title = articlePageParam.getTitle();

        // 构建查询条件
        Page<Articles> articlesPage = new Page<>(articlePageParam.getPageNo(), articlePageParam.getPageSize());
        articlesPage.addOrder(OrderItem.desc("create_time")).addOrder(OrderItem.desc("update_time"));
        // new QueryWrapper<Articles>().lambda().
        //         like(Articles::getTitle, title).eq(Articles::getAuthor, author)
        LambdaQueryWrapper<Articles> articlesLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(title)){
            articlesLambdaQueryWrapper.like(Articles::getTitle, title);
        }
        if (StringUtils.isNotBlank(author)){
            articlesLambdaQueryWrapper.like(Articles::getAuthor, author);
        }
        Page<Articles> pageList = articlesMapper.selectPage(articlesPage,articlesLambdaQueryWrapper);
        PublicPageDto<Articles> publicPageDto = new PublicPageDto<>();
        publicPageDto.setTotal(pageList.getTotal());
        publicPageDto.setPages(pageList.getPages());
        publicPageDto.setData(pageList.getRecords());
        return publicPageDto;

    }


}
