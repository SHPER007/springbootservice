package com.example.springbootservice.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootservice.conf.enums.ArticleCateGoryEnum;
import com.example.springbootservice.conf.enums.ArticleIsPublicEnum;
import com.example.springbootservice.conf.enums.ArticleListTypeEnum;
import com.example.springbootservice.conf.enums.OrderByEnum;
import com.example.springbootservice.conf.utils.DateFormatUtil;
import com.example.springbootservice.conf.utils.ThreadLocalUtil;
import com.example.springbootservice.domain.params.ArticlePageParam;
import com.example.springbootservice.domain.params.ArticleParam;
import com.example.springbootservice.domain.po.Articles;
import com.example.springbootservice.domain.po.ArticlesCategory;
import com.example.springbootservice.domain.po.ArticlesFavorites;
import com.example.springbootservice.domain.po.User;
import com.example.springbootservice.domain.responsevo.ArticlesCategoryResDto;
import com.example.springbootservice.domain.responsevo.PublicPageDto;
import com.example.springbootservice.domain.responsevo.UserArticlesResDto;
import com.example.springbootservice.mapper.ArticlesCategoryMapper;
import com.example.springbootservice.mapper.ArticlesFavoritesMapper;
import com.example.springbootservice.mapper.ArticlesMapper;
import com.example.springbootservice.mapper.UserMapper;
import com.example.springbootservice.services.ArticleService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.time.Instant;
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
    UserMapper userMapper;
    @Resource
    ArticlesMapper articlesMapper;

    @Resource
    ArticlesFavoritesMapper articlesFavoritesMapper;

    @Resource
    ArticlesCategoryMapper articlesCategoryMapper;

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
    public PublicPageDto<Articles> getPublicArticlesList(ArticlePageParam articlePageParam) {
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
        /*判断是查什么类型文章*/
        if(articlePageParam.getArticleListType() == ArticleListTypeEnum.PUBLIC_ARTICLES.getValue()){
            articlesLambdaQueryWrapper.eq(Articles::getIsPublic, 1).eq(Articles::getIsApproved, 1);

        } else if (articlePageParam.getArticleListType() == ArticleListTypeEnum.PERSONAL_ARTICLES.getValue()) {
            articlesLambdaQueryWrapper.eq(Articles::getUserid, ThreadLocalUtil.get());
        }else {
            ArrayList<Integer> articlesFavoritesList = new ArrayList<>();
            articlesFavoritesMapper.selectList(new LambdaQueryWrapper<ArticlesFavorites>().eq(ArticlesFavorites::getUserId, ThreadLocalUtil.get())).forEach(articlesFavorites -> {
                articlesFavoritesList.add(articlesFavorites.getArticleId());
            });
            if(!articlesFavoritesList.isEmpty()){
                articlesLambdaQueryWrapper.in(Articles::getId, articlesFavoritesList);
            }else {
                return null;
            }
        }
        /*判断要查询不同列表中文章分类*/
        // ALL_ARTICLES_CATEGORY(1, "全部文章"),
        // EMOTION_ARTICLES_CATEGORY(2,"情感文章"),
        //         LIFE_ARTICLES_CATEGORY(3, "生活文章"),
        //         FINANCE_ARTICLES_CATEGORY(4, "财务文章"),
        //         THINK_ARTICLES_CATEGORY(5, "感悟文章"),
        //         OTHER_ARTICLES_CATEGORY(5, "其他文章");
        switch (articlePageParam.getArticleClassify()) {
            case 1:
                break;
            case 2:
                articlesLambdaQueryWrapper.eq(Articles::getArticleCateGory, ArticleCateGoryEnum.EMOTION_ARTICLES_CATEGORY.getValue());
                break;
            case 3:
                articlesLambdaQueryWrapper.eq(Articles::getArticleCateGory, ArticleCateGoryEnum.LIFE_ARTICLES_CATEGORY.getValue());
                break;
            case 4:
                articlesLambdaQueryWrapper.eq(Articles::getArticleCateGory, ArticleCateGoryEnum.FINANCE_ARTICLES_CATEGORY.getValue());
                break;
            case 5:
                articlesLambdaQueryWrapper.eq(Articles::getArticleCateGory, ArticleCateGoryEnum.THINK_ARTICLES_CATEGORY.getValue());
                break;
            case 6:
                articlesLambdaQueryWrapper.eq(Articles::getArticleCateGory, ArticleCateGoryEnum.OTHER_ARTICLES_CATEGORY.getValue());
                break;

        }

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

    /**
     *Params:[]
     *Return:com.example.springbootservice.domain.responsevo.ArticlesCategoryResDto
     *Description: 文章分类接口
     */
    @Override
    public ArticlesCategoryResDto getArticlesCategory() {

        List<ArticlesCategory> articlesCategories = articlesCategoryMapper.selectList(new QueryWrapper<>());
        if (articlesCategories == null || articlesCategories.isEmpty()) {
            return null;
        }
        ArticlesCategoryResDto articlesCategoryResDto = new ArticlesCategoryResDto();
        articlesCategoryResDto.setData(articlesCategories);
        return articlesCategoryResDto;
    }

    @Override
    public Boolean createArticle(ArticleParam articleParam) {
        // 判断参数
        if (articleParam == null) {
            return false;
        }
        if (articleParam.getCategoryId() == null){
            return false;
        }else {
            if (articleParam.getCategoryId() < 2 || articleParam.getCategoryId() > 6){
                return false;
            }
        }
        ArticleCateGoryEnum articleCateGoryEnum;
        try {
            articleCateGoryEnum = ArticleCateGoryEnum.getEnum(articleParam.getCategoryId());
        }catch (Exception e){
            log.info("create article error", e);
            return false;
        }

        Articles articles = new Articles();
        articles.setArticleCateGory(articleCateGoryEnum);
        articles.setTitle(articleParam.getTitle());
        articles.setContent(articleParam.getContent());
        articles.setCreatePlace(articleParam.getPlace());
        articles.setWeather(articleParam.getWeather());
        articles.setUserid(ThreadLocalUtil.get());
        User user = userMapper.getUserById(ThreadLocalUtil.get());
        articles.setAuthor(user.getNickName());
        if(articleParam.getIsPublic()!= null){
            if (articleParam.getIsPublic() == ArticleIsPublicEnum.ARTICLE_PUBLIC.getValue()){
                articles.setIsPublic(true);
                articles.setIsApproved(false);
            }else {
                articles.setIsPublic(false);
                articles.setIsApproved(false);
            }
        }
        articles.setCreatTime(String.valueOf(Instant.now().toEpochMilli()));
        articles.setUpdateTime(String.valueOf(Instant.now().toEpochMilli()));
        int insert = articlesMapper.insert(articles);
        if (insert == 1){
            return true;
        }else {
            return false;
        }

    }

    private static PublicPageDto<Articles> getArticlesPublicPageDto(Page<Articles> pageList) {
        PublicPageDto<Articles> publicPageDto = new PublicPageDto<>();
        publicPageDto.setTotal(pageList.getTotal());
        publicPageDto.setPages(pageList.getPages());
        List<Articles> records = pageList.getRecords();
        // 你不能保证查出的数据 item.getUpdateTime() 不为null 所以还是得先判断
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
