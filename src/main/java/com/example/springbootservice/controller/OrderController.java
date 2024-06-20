package com.example.springbootservice.controller;

import com.example.springbootservice.paramdto.OrderCreatParam;
import com.example.springbootservice.paramdto.UserDtoParam;
import com.example.springbootservice.paramdto.UserOrderDtoParam;
import com.example.springbootservice.response.BaseResponseResult;
import com.example.springbootservice.services.OrderService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
    @RequestMapping("/order")
    public BaseResponseResult creatOrder(@RequestBody @Valid UserOrderDtoParam userOrderDtoParam){
        UserDtoParam userDtoParam = userOrderDtoParam.getUserDtoParam();
        OrderCreatParam orderCreatParam = userOrderDtoParam.getOrderCreatParam();
        boolean orderResult = orderService.creatOrder(userDtoParam, orderCreatParam);
        if (!orderResult){
            return BaseResponseResult.fail(HttpStatus.BAD_REQUEST.value(),"下单失败");
        }
        return BaseResponseResult.success(HttpStatus.OK.value(),"OK", null);

    }
}
