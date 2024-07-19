package com.example.springbootservice.conf.configbean;

import com.example.springbootservice.conf.filter.TraceIdFilter;
import com.example.springbootservice.conf.utils.RedisLockUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
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

    /**
     *Params:[factory]
     *Return:org.springframework.data.redis.core.RedisTemplate<java.lang.String,java.lang.Object>
     *Description:redis配置参数
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        // 设置redis连接工厂
        template.setConnectionFactory(factory);
        // new GenericJackson2JsonRedisSerializer() 会默认存储类型到redis 增加存储量,默认手动来转
        // Jackson2JsonRedisSerializer 不会把类型 存储到redis中去 需要手动转化
        Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer<>(Object.class);
        // 设置key的序列化方式
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        // 设置value的序列化方式
        template.setValueSerializer(serializer);
        template.setHashValueSerializer(serializer);

        template.afterPropertiesSet();

        return template;
    }


    @Bean
    public RestTemplate restTemplate() {
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
