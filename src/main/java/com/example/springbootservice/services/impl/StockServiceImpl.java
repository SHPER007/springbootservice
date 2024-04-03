package com.example.springbootservice.services.impl;

import com.example.springbootservice.conf.contants.RedisExpire;
import com.example.springbootservice.paramdto.OrderCreatParam;
import com.example.springbootservice.paramdto.UserDto;
import com.example.springbootservice.services.OrderService;
import com.example.springbootservice.conf.utils.RedisLockUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * ClassName:StockService
 * Package:com.example.springbootservice.services.impl
 * Description:TODO
 * Date:2024/3/31 0031 20:55
 * Author:2498897200@qq.com
 */
@Slf4j
@Service
public class StockServiceImpl implements OrderService {

    @Resource
    RedisLockUtil redisLockUtil;

    @Override
    public boolean creatOrder(UserDto userDto, OrderCreatParam param) {
        String lockKey = "stock_lock"+param.getProductId();
        String lockValue = UUID.randomUUID().toString();

        boolean isGetLock = redisLockUtil.tryGetLock(lockKey, lockValue, RedisExpire.EXPIRE_TIME);
        if (!isGetLock){
            log.info("fail to get lock");
            return false;
        }
        log.info("上锁成功");
        log.info("执行扣减库存逻辑");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            log.info("释放锁");
            redisLockUtil.releaseLock(lockKey, lockValue);
            return true;
        }

    }
}
