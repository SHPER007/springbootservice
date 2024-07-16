package com.example.springbootservice.controller;

import com.example.springbootservice.domain.responsevo.HeadInfoResVo;
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
        HeadInfoResVo headInfoResponseDto = navHeadInfoService.getHeadInfoByUserId();
        log.info("navinfo res data:{}",headInfoResponseDto.toString());
        return BaseResponseResult.success(HttpStatus.OK.value(), "OK", headInfoResponseDto);
    }
}
