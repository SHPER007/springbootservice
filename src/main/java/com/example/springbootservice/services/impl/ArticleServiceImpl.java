package com.example.springbootservice.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootservice.conf.enums.OrderByEnum;
import com.example.springbootservice.conf.utils.DateFormatUtil;
import com.example.springbootservice.conf.utils.ThreadLocalUtil;
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

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        List<Articles> articlesList = articlesMapper.selectList(new QueryWrapper<Articles>().lambda().eq(Articles::getUserid, ThreadLocalUtil.get()));
        if (articlesList == null || articlesList.isEmpty()) {
            return null;
        }
        articlesList.forEach(item -> {
            String creatTimeFormat = DateFormatUtil.formatDate(item.getCreatTime());
            String updateTimeFormat = DateFormatUtil.formatDate(item.getUpdateTime());
            item.setCreatTime(creatTimeFormat);
            item.setUpdateTime(updateTimeFormat);
        });
        UserArticlesResDto userArticlesResDto = new UserArticlesResDto();
        userArticlesResDto.setArticlesLists(articlesList);
        return userArticlesResDto;
    }

    @Override
    public PublicPageDto<Articles> getUserArticlesPage(ArticlePageParam articlePageParam) {
        if (articlePageParam == null) {
            return null;
        }
        List<String> utcTimeStringList = articlePageParam.getDate();
        ArrayList<Long> utcTimeStampList = new ArrayList<>();
        if (utcTimeStringList != null && !utcTimeStringList.isEmpty()) {
            utcTimeStringList.forEach(utcTimeString -> {
                long epochMilli = ZonedDateTime.parse(utcTimeString, DateTimeFormatter.ISO_ZONED_DATE_TIME).toInstant().toEpochMilli();
                utcTimeStampList.add(epochMilli);
            });
        }
        // 构建查询条件
        LambdaQueryWrapper<Articles> articlesLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(articlePageParam.getTitle())){
            articlesLambdaQueryWrapper.like(Articles::getTitle, articlePageParam.getTitle());
        }
        if (StringUtils.isNotBlank(articlePageParam.getAuthor())){
            articlesLambdaQueryWrapper.like(Articles::getAuthor, articlePageParam.getAuthor());
        }
        if(!utcTimeStampList.isEmpty()){
            if (Objects.equals(articlePageParam.getOrderBy(), OrderByEnum.CREATE_TIME.getValue())){
                articlesLambdaQueryWrapper.between(Articles::getCreatTime, utcTimeStampList.get(0), utcTimeStampList.get(utcTimeStampList.size() - 1));
            }else
                articlesLambdaQueryWrapper.between(Articles::getUpdateTime,  utcTimeStampList.get(0), utcTimeStampList.get(utcTimeStampList.size() - 1));
        }

        Page<Articles> articlesPage = new Page<>(articlePageParam.getPageNo(), articlePageParam.getPageSize());
        // 是否正序 依据什么字段排序
        if (articlePageParam.getIsAsc()) {
            // 按照创建时间正序
            if (Objects.equals(articlePageParam.getOrderBy(), OrderByEnum.CREATE_TIME.getValue())){
                articlesPage.addOrder(OrderItem.asc("create_time")).addOrder(OrderItem.asc("update_time"));
            // 按照更新时间正序
            }else {
                articlesPage.addOrder(OrderItem.asc("update_time")).addOrder(OrderItem.asc("create_time"));
            }
        }else {
            // 倒叙
            if (Objects.equals(articlePageParam.getOrderBy(), OrderByEnum.CREATE_TIME.getValue())){
                articlesPage.addOrder(OrderItem.desc("create_time")).addOrder(OrderItem.desc("update_time"));
            }else {
                articlesPage.addOrder(OrderItem.desc("update_time")).addOrder(OrderItem.desc("create_time"));
            }
        }
        // new QueryWrapper<Articles>().lambda().
        //         like(Articles::getTitle, title).eq(Articles::getAuthor, author)

        Page<Articles> pageList = articlesMapper.selectPage(articlesPage,articlesLambdaQueryWrapper);
        PublicPageDto<Articles> publicPageDto = getArticlesPublicPageDto(pageList);
        return publicPageDto;

    }

    private static PublicPageDto<Articles> getArticlesPublicPageDto(Page<Articles> pageList) {
        PublicPageDto<Articles> publicPageDto = new PublicPageDto<>();
        publicPageDto.setTotal(pageList.getTotal());
        publicPageDto.setPages(pageList.getPages());
        List<Articles> records = pageList.getRecords();
        records.forEach(item -> {
            String creatTimeFormat = DateFormatUtil.formatDate(item.getCreatTime());
            String updateTimeFormat = DateFormatUtil.formatDate(item.getUpdateTime());
            item.setCreatTime(creatTimeFormat);
            item.setUpdateTime(updateTimeFormat);
        });
        publicPageDto.setData(records);
        return publicPageDto;
    }


}
