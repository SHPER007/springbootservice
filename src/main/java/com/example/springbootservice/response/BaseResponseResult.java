package com.example.springbootservice.response;

import com.example.springbootservice.conf.utils.GenerateTraceIdUtil;
import lombok.Data;

import java.io.Serializable;

/**
 * ClassName:ResponseResult
 * Package:com.example.springbootservice.response
 * Description:TODO
 * Date:2024/3/30 0030 0:27
 * Author:2498897200@qq.com
 */

@Data
public class BaseResponseResult implements Serializable {
    private int code;
    private Boolean success;
    private String message;
    private Object data;
    private String traceId = GenerateTraceIdUtil.getTracId();

    public static BaseResponseResult success(int code, String message){
        BaseResponseResult baseResponseResult = new BaseResponseResult();
        baseResponseResult.setCode(code);
        baseResponseResult.setSuccess(true);
        baseResponseResult.setMessage(message);
        return baseResponseResult;
    }

    public static BaseResponseResult success(int code, String message, Object data){
        if(data == null){
            data = "";
        }
        BaseResponseResult baseResponseResult = success(code, message);
        baseResponseResult.setData(data);
        return baseResponseResult;
    }

    public static BaseResponseResult fail(int code, String message){
        BaseResponseResult baseResponseResult = new BaseResponseResult();
        baseResponseResult.setCode(code);
        baseResponseResult.setSuccess(false);
        baseResponseResult.setMessage(message);
        return baseResponseResult;

    }











}
