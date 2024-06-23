package com.example.springbootservice.resdto;

import lombok.Data;

import java.util.List;

/**
 * ClassName:GeoResDto
 * Description:TODO
 * Author:SunHang
 * Date:2024/6/23 17:19
 */
@Data
public class GeoResDto {
    private String status;
    private String count;
    private String info;
    private String infocode;
    private List<GeoCodeResDto> geocodes;


}
