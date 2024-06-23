package com.example.springbootservice.services;

import com.example.springbootservice.resdto.HeadInfoResDto;

/**
 * ClassName:NavHeadInfoService
 * Description:网站首页信息
 * Author:SunHang
 * Date:2024/6/23 14:10
 */

public interface NavInfoService {

    HeadInfoResDto getHeadInfoByUserId(Integer userid);
}
