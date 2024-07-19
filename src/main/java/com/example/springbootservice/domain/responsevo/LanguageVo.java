package com.example.springbootservice.domain.responsevo;

import lombok.Data;

/**
 * ClassName:LanguageDto
 * Description:TODO
 * Author:SunHang
 * Date:2024/7/7 23:38
 */
@Data
public class LanguageVo {
    private String chinese;
    private String english;

    public LanguageVo(String chinese, String english){
        this.chinese = chinese;
        this.english = english;

    }
}
