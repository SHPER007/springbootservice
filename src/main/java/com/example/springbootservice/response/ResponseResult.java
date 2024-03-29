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
public class ResponseResult<T> implements Serializable {
    private int code;
    private String message;
    private T data;

    public ResponseResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
