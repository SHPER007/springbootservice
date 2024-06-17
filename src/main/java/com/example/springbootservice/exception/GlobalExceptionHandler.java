package com.example.springbootservice.exception;

import com.example.springbootservice.response.BaseResponseResult;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * ClassName:GlobalExceptionHandler
 * Package:com.example.springbootservice.exception
 * Description:TODO
 * Date:2024/4/5 0005 13:24
 * Author:2498897200@qq.com
 * @RestControllerAdvice：将其注入springboot容器中
 */

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler({NullPointerException.class, ArithmeticException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseResponseResult nullPointerExceptionRun(HttpServletRequest request, Throwable e){
        String message = "服务繁忙,请稍后再试！";
        log.info("全局捕获异常{}", e.toString());
        return BaseResponseResult.fail(message);
    }
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler(JwtGenerationException.class)
//    public BaseResponseResult handleJwtGenerationException(JwtGenerationException ex) {
//        String message = "token生成失败！";// 设置一个错误标记或者默认值
//        LoginResponseDto errorResponse = new LoginResponseDto();
//        errorResponse.setToken("ERR_TOKEN_GENERATION");
//        return BaseResponseResult.fail(message);
//    }

}
