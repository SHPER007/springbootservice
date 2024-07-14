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

    public static ArrayList<Long> getTimestampFromStringTime(OffsetDateTime offsetDateTime, String  localStartTime, String localEndTime) {

        ZoneId userTimeZone = ZoneId.of("Asia/Shanghai"); // 东八区

        // 直接使用已有的OffsetDateTime对象 获取用户时区的ZonedDateTime
        ZonedDateTime userZonedDateTime = offsetDateTime.atZoneSameInstant(userTimeZone);

        // 获取用户时区的日期
        LocalDate userDate = userZonedDateTime.toLocalDate();

        // 解析本地时间字符串

        LocalTime startTimeObj = LocalTime.parse(localStartTime, DateTimeFormatter.ofPattern("HH:mm"));
        LocalTime endTime0bj = LocalTime.parse(localEndTime, DateTimeFormatter.ofPattern("HH:mm"));

        // 创建LocalDateTime结合用户时区的日期和本地时间
        LocalDateTime userLocalStartDateTime = LocalDateTime.of(userDate, startTimeObj);
        LocalDateTime userLocalEndDateTime = LocalDateTime.of(userDate, endTime0bj);

        // 将LocalDateTime与用户时区结合
        ZonedDateTime zonedStartDateTime = userLocalStartDateTime.atZone(userTimeZone);
        ZonedDateTime zonedEndDateTime = userLocalEndDateTime.atZone(userTimeZone);

        // 将ZonedDateTime转换为UTC的Instant
        Long startTimeStamp = zonedStartDateTime.withZoneSameInstant(ZoneOffset.UTC).toInstant().toEpochMilli();
        Long endTimeStamp = zonedEndDateTime.withZoneSameInstant(ZoneOffset.UTC).toInstant().toEpochMilli();

        ArrayList<Long> timeStampList = new ArrayList<>();
        timeStampList.add(startTimeStamp);
        timeStampList.add(endTimeStamp);
        return timeStampList;
    }

}
