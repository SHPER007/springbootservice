package com.example.springbootservice.conf.utils;

import com.example.springbootservice.domain.responsevo.LanguageVo;

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
    private static final List<LanguageVo>  superLanguage = new ArrayList<>();
    static {
        superLanguage.add(new LanguageVo("生命的意义本不在向外的的寻求，而在向内的建立","The meaning of life is not to seek outward, but to build inward"));
        superLanguage.add(new LanguageVo("决定放弃了的事 就请放弃的干干净净  那些决定再也不见面的人 就真的不要见面了 请不用做背叛自己的事","The meaning of life is not to seek outward, but to build inward"));
        superLanguage.add(new LanguageVo("如果你抑郁了，说明你活在过去，如果你焦虑了，说明你活在未来，如果你平静了，才说明你活在现在。\n","The meaning of life is not to seek outward, but to build inward"));
        superLanguage.add(new LanguageVo("生命的意义本不在向外的的寻求，而在向内的建立","The meaning of life is not to seek outward, but to build inward"));

    }
    public static LanguageVo getSuperLanguage() {
        int randomNumber = ThreadLocalRandom.current().nextInt(0, superLanguage.size()); // 生成0到5的随机整数，左闭右开区间
        return superLanguage.get(randomNumber) ;
    }
}
