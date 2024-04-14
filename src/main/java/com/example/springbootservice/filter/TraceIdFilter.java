package com.example.springbootservice.filter;


import com.example.springbootservice.conf.utils.GenerateTraceIdUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * ClassName:TraceIdFilter
 * Package:com.example.springbootservice.filter
 * Description:TODO
 * Date:2024/4/5 0005 0:15
 * Author:2498897200@qq.com
 */

@Slf4j
public class TraceIdFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init trace filter..");

    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
            String gateWayIsHaveTracId = httpServletRequest.getHeader(GenerateTraceIdUtil.TRACE_ID_KEY);
            GenerateTraceIdUtil.generateTracIdToMdc(gateWayIsHaveTracId);
            log.info("设置traceId");
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception e) {
            log.info("设置traceId的过滤器中出现异常{}", e.toString());
        } finally {
            log.info("移除traceId");
            GenerateTraceIdUtil.removeTraceId();

        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
