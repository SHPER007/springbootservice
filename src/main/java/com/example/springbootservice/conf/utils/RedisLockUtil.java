package com.example.springbootservice.conf.utils;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.script.DefaultRedisScript;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

/**
 * ClassName:DoLcokUtil
 * Package:com.example.springbootservice.utils
 * Description:TODO
 * Date:2024/3/31 0031 21:03
 * Author:2498897200@qq.com
 */
@Slf4j
public class RedisLockUtil {
    @Resource
    RedisTemplate<String, Object> redisTemplate;

    public boolean tryGetLock(String lockRedisKey, String lockRedisValue, Long expireTime){
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        Boolean result = valueOperations.setIfAbsent(lockRedisKey, lockRedisValue, expireTime, TimeUnit.MILLISECONDS);
        return Boolean.TRUE.equals(result);
    }

    public boolean releaseLock(String lockRedisKey, String lockRedisValue){
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then " +
                "return redis.call('del', KEYS[1]) " +
                "else " +
                "return 0 " +
                "end";
        Long result = (Long) redisTemplate.execute(
                new DefaultRedisScript<>(script, Long.class),
                Collections.singletonList(lockRedisKey),
                lockRedisValue);
        return result!=null && result > 0;
    }

}
