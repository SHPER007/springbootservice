package com.example.springbootservice.resdto;

import lombok.Data;

/**
 * ClassName:GeoCodeResDto
 * Description:TODO
 * Author:SunHang
 * Date:2024/6/23 17:20
 */
@Data
public class GeoCodeResDto {
    private String location;
    private String precise;
    private String confidence;
    private String comprehension;
    private String level;
    private String citycode;
    private String adcode;

}
