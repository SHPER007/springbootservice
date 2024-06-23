package com.example.springbootservice.conf.utils;

/**
 * ClassName:SubStringUtil
 * Description:处理NavHeadInfoController接口中头返回值city的截取工具类,返回前三位
 * Author:SunHang
 * Date:2024/6/23 14:31
 */
public class SubStringUtil {
    public static String getFirstThreeCharacters(String src) {
        if (src == null || src.isEmpty()){
            return null;
        }
        if (src.length() >= 3) {
            return src.substring(0, 3);
        }
        return src;

    }
}
