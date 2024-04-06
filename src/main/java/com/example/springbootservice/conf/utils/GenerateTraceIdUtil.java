package com.example.springbootservice.conf.utils;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;


/**
 * ClassName:GenerateTraceidUtil
 * Package:com.example.springbootservice.conf.utils
 * Description:TODO
 * Date:2024/4/4 0004 23:38
 * Author:2498897200@qq.com
 */
public class GenerateTraceIdUtil {

    public static final String TRACE_ID_KEY = "TraceId";

    public static void generateTracIdToMdc(){
        String tracId = IdUtil.fastSimpleUUID().toUpperCase();
        MDC.put(TRACE_ID_KEY, tracId);
    }

    public static void generateTracIdToMdc(String traced){
        if (StringUtils.isBlank(traced)){
            generateTracIdToMdc();
            return;
        }
        MDC.put(TRACE_ID_KEY, traced);
    }

    public static String getTracId(){
        return MDC.get(TRACE_ID_KEY);
    }

    public static void removeTraceId(){
        MDC.remove(TRACE_ID_KEY);
    }


}
