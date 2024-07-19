package com.example.springbootservice.conf.utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
@Slf4j
@Component
public class RedisUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    // 获取 ValueOperations 实例，用于基本的 CRUD 操作
    private ValueOperations<String, Object> getValueOperations() {
        return redisTemplate.opsForValue();
    }

    private ValueOperations<String, String> getStringValueOperations() {
        return stringRedisTemplate.opsForValue();
    }


    public Boolean set(String key, Object value) {
        try {
            getValueOperations().set(key, value);
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Error while setting value to Redis: " + e.getMessage(), e);
        }
    }

    public void setJavaBean(String key, Object value,  long expire) {
        try {
            String json = objectMapper.writeValueAsString(value);
            getStringValueOperations().set(key, json);
            stringRedisTemplate.expire(key, expire, TimeUnit.SECONDS);
        } catch (Exception e) {
            log.info("Error while setting value to Redis:{}", e.getMessage());
        }
    }

    public <T> T getJavaBean(String key, Class<T> clazz) {
        try {
            String json = getStringValueOperations().get(key);
            return objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            log.info("Error while setting value to Redis: " + e.getMessage(), e);
            return null;
        }
    }

    public Object get(String key) {
        return getValueOperations().get(key);
    }

    public Boolean set(String key, Object value, long expire) {
        try {
            getValueOperations().set(key, value);
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Error while setting value with expiration time to Redis: " + e.getMessage(), e);
        }
    }

    public Boolean exists(String key) {
        return redisTemplate.hasKey(key);
    }

    public Boolean delete(String key) {
        if (Boolean.TRUE.equals(redisTemplate.delete(key))) {
            return true;
        } else {
            return false;
        }
    }

    public Long increment(String key, long delta) {
        return getValueOperations().increment(key, delta);
    }

    public Long decrement(String key, long delta) {
        return getValueOperations().increment(key, -delta);
    }

    // 为方便起见，可以添加一些更具体的类型方法，例如：
    public String getString(String key) {
        return (String) getValueOperations().get(key);
    }

    public void setString(String key, String value) {
        set(key, value);
    }

    public Integer getInteger(String key) {
        return (Integer) getValueOperations().get(key);
    }

    public void setInteger(String key, Integer value) {
        set(key, value);
    }

}