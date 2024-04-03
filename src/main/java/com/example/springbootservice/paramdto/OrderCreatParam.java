package com.example.springbootservice.paramdto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * ClassName:OrederCreatParam
 * Package:com.example.springbootservice.projectdto
 * Description:TODO
 * Date:2024/3/31 0031 20:38
 * Author:2498897200@qq.com
 */
@Data
public class OrderCreatParam {
    @NotNull
    private Integer count;
    @NotNull
    private Integer productId;
}
