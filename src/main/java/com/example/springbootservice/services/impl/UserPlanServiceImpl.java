package com.example.springbootservice.services.impl;

import com.example.springbootservice.conf.utils.DateFormatUtil;
import com.example.springbootservice.conf.utils.SuperLanguage;
import com.example.springbootservice.mapperdao.UserPlanMapper;
import com.example.springbootservice.mysqlbean.UserPlan;
import com.example.springbootservice.resdto.LanguageDto;
import com.example.springbootservice.resdto.UserPlanDto;
import com.example.springbootservice.services.UserPlanService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:UserPlanServiceImpl
 * Description:TODO
 * Author:SunHang
 * Date:2024/7/7 18:05
 */

@Slf4j
@Service
public class UserPlanServiceImpl implements UserPlanService {
    @Resource
    UserPlanMapper userPlanMapper;

    @Override
    public UserPlanDto getUserPlan(Integer userId) {
        List<UserPlan> userPlanList = userPlanMapper.getUserPlanList(userId);
        if(userPlanList.size()>0){
            setFormatTime(userPlanList);
            LanguageDto LanguageDto = SuperLanguage.getSuperLanguage();
            UserPlanDto userPlanDto = new UserPlanDto();
            userPlanDto.setListPlan(userPlanList);
            userPlanDto.setChinese(LanguageDto.getChinese());
            userPlanDto.setEnglish(LanguageDto.getEnglish());
            return userPlanDto;
        }
        return null;

    }

    public void setFormatTime(List<UserPlan> userPlanList){
        for (UserPlan userPlan : userPlanList) {
            String starTime = DateFormatUtil.formatDate(Long.parseLong(userPlan.getStartTime()));
            String endTime = DateFormatUtil.formatDate(Long.parseLong(userPlan.getEndTime()));
            String creatTime = DateFormatUtil.formatDate(Long.parseLong(userPlan.getCreatedAt()));
            userPlan.setStartTime(starTime);
            userPlan.setEndTime(endTime);
            userPlan.setCreatedAt(creatTime);
        }
    }

}
