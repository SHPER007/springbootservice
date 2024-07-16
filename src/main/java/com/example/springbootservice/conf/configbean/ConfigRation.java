package com.example.springbootservice.conf.configbean;

import com.example.springbootservice.conf.utils.RedisLockUtil;
import com.example.springbootservice.conf.filter.TraceIdFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName:ConfigRation
 * Package:com.example.springbootservice.configration
 * Description:注册traceID过滤器
 * Date:2024/4/1 0001 0:45
 * Author:2498897200@qq.com
 */
@Slf4j
@Configuration
public class ConfigRation {

    @Bean
    public RestTemplate restTemplate() {
        // 这里可以根据需要自定义RestTemplate的配置
        return new RestTemplate();
    }

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
