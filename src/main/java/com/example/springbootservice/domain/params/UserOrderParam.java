package com.example.springbootservice.domain.params;

import jakarta.validation.Valid;
import lombok.Data;

/**
 * ClassName:UserOrderDto
 * Package:com.example.springbootservice.projectdto
 * Description: 用户订单请求参数
 * Date:2024/4/1 0001 1:45
 * Author:2498897200@qq.com
 */
@Data
public class UserOrderParam {
    @Valid
    private UserParamQuery UserParamQuery;
    private OrderCreatQuery orderCreatParam;
}
