package com.example.springbootservice.paramdto;

import jakarta.validation.Valid;
import lombok.Data;

/**
 * ClassName:UserOrderDto
 * Package:com.example.springbootservice.projectdto
 * Description:TODO
 * Date:2024/4/1 0001 1:45
 * Author:2498897200@qq.com
 */
@Data
public class UserOrderDtoParam {
    @Valid
    private UserDtoParam UserDtoParam;
    private OrderCreatParam orderCreatParam;
}
