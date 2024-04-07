package com.example.springbootservice.conf.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.logging.Log;

/**
 * ClassName:MybatisLog
 * Package:com.example.springbootservice.conf.utils
 * Description:TODO
 * Date:2024/4/7 0007 23:45
 * Author:2498897200@qq.com
 */

@Slf4j
public class MybatisLog implements Log {

    public  MybatisLog(String clazz){

    }

    @Override
    public boolean isDebugEnabled() {
        return true;
    }

    @Override
    public boolean isTraceEnabled() {
        return true;
    }

    @Override
    public void error(String s, Throwable e) {
        log.error(s, e);

    }

    @Override
    public void error(String s) {
        log.error(s);

    }

    @Override
    public void debug(String s) {
        log.debug(s);

    }

    @Override
    public void trace(String s) {
        log.trace(s);

    }

    @Override
    public void warn(String s) {
        log.warn(s);

    }
}
