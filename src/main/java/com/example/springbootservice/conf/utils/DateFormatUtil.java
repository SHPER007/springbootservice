package com.example.springbootservice.conf.utils;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * ClassName:DateFormatUtil
 * Description:时间戳转时间格式字符串工具类
 * Author:SunHang
 * Date:2024/7/7 23:24
 */
public class DateFormatUtil {

    public static String formatDate(Long timestamp) {
        Instant instant = Instant.ofEpochMilli(timestamp);
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = zonedDateTime.format(formatter);
        return format;
    }
}
