package com.example.springbootservice.response;

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
    private Boolean success;
    private String message;
    private Object data;

    public static BaseResponseResult success(String message){
        BaseResponseResult baseResponseResult = new BaseResponseResult();
        baseResponseResult.setSuccess(true);
        baseResponseResult.setMessage(message);
        return baseResponseResult;
    }

    public static BaseResponseResult success(String message, Object data){
        if(data == null){
            data = "";
        }
        BaseResponseResult baseResponseResult = new BaseResponseResult();
        baseResponseResult.setSuccess(true);
        baseResponseResult.setMessage(message);
        baseResponseResult.setData(data);
        return baseResponseResult;
    }



    public static BaseResponseResult fail(String message){
        BaseResponseResult baseResponseResult = new BaseResponseResult();
        baseResponseResult.setSuccess(false);
        baseResponseResult.setMessage(message);
        return baseResponseResult;

    }











}
