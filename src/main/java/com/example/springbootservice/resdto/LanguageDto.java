package com.example.springbootservice.resdto;

import lombok.Data;

/**
 * ClassName:LanguageDto
 * Description:TODO
 * Author:SunHang
 * Date:2024/7/7 23:38
 */
@Data
public class LanguageDto {
    private String chinese;
    private String english;

    public LanguageDto(String chinese, String english){
        this.chinese = chinese;
        this.english = english;

    }
}
