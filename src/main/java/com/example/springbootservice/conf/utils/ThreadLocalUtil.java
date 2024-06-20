package com.example.springbootservice.conf.utils;

/**
 * ClassName:ThreadLocalUtil
 * Description:threadlocal 工具类 线程储存token
 * Author:SunHang
 * Date:2024/6/20 22:24
 */
public class ThreadLocalUtil {
    private static final ThreadLocal THREAD_LOCAl = new ThreadLocal<>();

    public static <T> T get() {
        return (T)THREAD_LOCAl.get();
    }

    public static void set(Object value) {
        THREAD_LOCAl.set(value);
    }
    public static void remove() {
        THREAD_LOCAl.remove();
    }



}
