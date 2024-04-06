package com.example.springbootservice.conf.configbean;

import com.example.springbootservice.conf.utils.RedisLockUtil;
import com.example.springbootservice.filter.TraceIdFilter;
import jakarta.servlet.Filter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * ClassName:Configer
 * Package:com.example.springbootservice.configration
 * Description:TODO
 * Date:2024/4/1 0001 0:45
 * Author:2498897200@qq.com
 */
@Slf4j
@Configuration
public class ConfigRation {

    @Bean
    public RedisLockUtil redisLockUtil(){
        return new RedisLockUtil();

    }
    @Bean
    @ConditionalOnMissingBean({TraceIdFilter.class})
    @Order(Ordered.HIGHEST_PRECEDENCE + 101)
    public FilterRegistrationBean<TraceIdFilter> TraceIdFilterFilterRegistration(){
        FilterRegistrationBean<TraceIdFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new TraceIdFilter());
        filterFilterRegistrationBean.addUrlPatterns("/*");
        return filterFilterRegistrationBean;
    }

}
