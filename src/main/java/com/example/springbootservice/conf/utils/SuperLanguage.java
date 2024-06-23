package com.example.springbootservice.conf.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * ClassName:SuperLanguage
 * Description:TODO
 * Author:SunHang
 * Date:2024/6/23 15:08
 */
public class SuperLanguage {
    private static final List<String>  superLanguage = new ArrayList<>();
    static {
        superLanguage.add("The greatest glory in living lies not in never falling, but in rising every time we fall.");
        superLanguage.add("Believe you can and you're halfway there.");
        superLanguage.add("Success is not final, failure is not fatal: It is the courage to continue that counts.");
        superLanguage.add("The way to get started is to quit talking and begin doing.");
        superLanguage.add("Your time is limited, don't waste it living someone else's life.");
    }
    public static String getSuperLanguage() {
        int randomNumber = ThreadLocalRandom.current().nextInt(0, superLanguage.size()); // 生成0到5的随机整数，左闭右开区间
        return superLanguage.get(randomNumber) ;
    }
}
