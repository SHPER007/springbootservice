package com.example.springbootservice.conf.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * ClassName:DateFormatUtil
 * Description:时间戳转时间格式字符串工具类
 * Author:SunHang
 * Date:2024/7/7 23:24
 */
public class DateFormatUtil {
    /**
     *Params:[timestamp]
     *Return:java.lang.String
     *Description: 时间戳格式化为 时间数据2024-07-08
     */
    public static String formatDate(Long timestamp) {
        Instant instant = Instant.ofEpochMilli(timestamp);
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = zonedDateTime.format(formatter);
        return format;
    }

    public static ArrayList<Long> getTimestampFromStringTime(OffsetDateTime offsetDateTime, String  startTime, String endTime) {
        LocalDate localDate = offsetDateTime.toLocalDate();
        // 创建开始时间和结束时间
        LocalTime startTimeLocal = LocalTime.parse(startTime, DateTimeFormatter.ofPattern("HH:mm"));
        LocalTime endTimeLocal = LocalTime.parse(endTime, DateTimeFormatter.ofPattern("HH:mm"));
        // 合并日期和时间
        LocalDateTime startDateTime = LocalDateTime.of(localDate, startTimeLocal);
        LocalDateTime endDateTime = LocalDateTime.of(localDate, endTimeLocal);

        // 转换为UTC的ZonedDateTime
        ZonedDateTime utcStartDateTime = startDateTime.atZone(ZoneOffset.UTC);
        ZonedDateTime utcEndDateTime = endDateTime.atZone(ZoneOffset.UTC);
        // 转换为UTC时间戳
        long startTimeStamp = utcStartDateTime.toInstant().toEpochMilli();
        long endTimeStamp = utcEndDateTime.toInstant().toEpochMilli();
        ArrayList<Long> timeStampList = new ArrayList<>();
        timeStampList.add(startTimeStamp);
        timeStampList.add(endTimeStamp);
        return timeStampList;
    }

}
