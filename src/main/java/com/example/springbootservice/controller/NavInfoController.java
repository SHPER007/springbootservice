package com.example.springbootservice.controller;

import com.example.springbootservice.domain.responsevo.HeadInfoResDto;
import com.example.springbootservice.domain.baseresponse.BaseResponseResult;
import com.example.springbootservice.services.NavInfoService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:NavHeadInfoController
 * Description:TODO
 * Author:SunHang
 * Date:2024/6/23 13:57
 */
@Slf4j
@RestController
@RequestMapping("/head")
public class NavInfoController {

    @Resource
    private NavInfoService navHeadInfoService;

    @GetMapping(value = "/info")
    public BaseResponseResult getHeadInfoByUserId(){
        try {
            HeadInfoResDto headInfoResponseDto = navHeadInfoService.getHeadInfoByUserId();
            return BaseResponseResult.success(HttpStatus.OK.value(), "OK", headInfoResponseDto);
        } catch (Exception e) {
            log.error(e.getMessage());
            return BaseResponseResult.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
        }

    }
}
