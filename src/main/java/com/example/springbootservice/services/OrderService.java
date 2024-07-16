package com.example.springbootservice.services;

import com.example.springbootservice.domain.params.OrderCreatQuery;
import com.example.springbootservice.domain.params.UserParamQuery;

/**
 * ClassName:StockService
 * Package:com.example.springbootservice.services
 * Description:TODO
 * Date:2024/3/31 0031 20:55
 * Author:2498897200@qq.com
 */
public interface OrderService {

    boolean creatOrder(UserParamQuery userParamQuery, OrderCreatQuery param);
}
