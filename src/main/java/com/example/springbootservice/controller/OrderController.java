package com.example.springbootservice.controller;

import com.example.springbootservice.domain.params.OrderCreatQuery;
import com.example.springbootservice.domain.params.UserParamQuery;
import com.example.springbootservice.domain.params.UserOrderParam;
import com.example.springbootservice.domain.baseresponse.BaseResponseResult;
import com.example.springbootservice.services.OrderService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:CommitOrder
 * Package:com.example.springbootservice.controller
 * Description:TODO
 * Date:2024/3/31 0031 20:32
 * Author:2498897200@qq.com
 */
@Slf4j
@RestController
@RequestMapping("/commit")
public class OrderController {
    @Resource
    OrderService orderService;
    @PostMapping("/order")
    public BaseResponseResult creatOrder(@RequestBody @Valid UserOrderParam userOrderParam){
        UserParamQuery userParamQuery = userOrderParam.getUserParamQuery();
        OrderCreatQuery orderCreatParam = userOrderParam.getOrderCreatParam();
        boolean orderResult = orderService.creatOrder(userParamQuery, orderCreatParam);
        if (!orderResult){
            return BaseResponseResult.fail(HttpStatus.BAD_REQUEST.value(),"下单失败");
        }
        return BaseResponseResult.success(HttpStatus.OK.value(),"OK", null);

    }
}
