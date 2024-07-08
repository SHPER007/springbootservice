package com.example.springbootservice.services.impl;

import com.example.springbootservice.conf.utils.DateFormatUtil;
import com.example.springbootservice.conf.utils.SuperLanguage;
import com.example.springbootservice.conf.utils.ThreadLocalUtil;
import com.example.springbootservice.mapperdao.UserPlanMapper;
import com.example.springbootservice.mysqlbean.UserPlan;
import com.example.springbootservice.mysqlbean.UserPlanBean;
import com.example.springbootservice.paramdto.UserPlanDtoParam;
import com.example.springbootservice.resdto.LanguageDto;
import com.example.springbootservice.resdto.UserPlanDto;
import com.example.springbootservice.services.UserPlanService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @Override
    public Boolean addUserPlan(UserPlanDtoParam userPlanDtoParam) {
        if (userPlanDtoParam == null) {
            return false;
        }
        try {
            String planName = userPlanDtoParam.getPlanName();
            OffsetDateTime planDate = userPlanDtoParam.getPlanDate();
            String location = userPlanDtoParam.getLocation();
            String endTime = userPlanDtoParam.getEndTime();
            String startTime = userPlanDtoParam.getStartTime();
            ArrayList<Long> timestampFromStringTime = DateFormatUtil.getTimestampFromStringTime(planDate, startTime, endTime);
            UserPlanBean userPlanBean = new UserPlanBean();
            userPlanBean.setPlanName(planName);
            userPlanBean.setLocation(location);
            userPlanBean.setStartTime(timestampFromStringTime.get(0));
            userPlanBean.setEndTime(timestampFromStringTime.get(1));
            userPlanBean.setCreatedAt(System.currentTimeMillis());

            Map<String, Object> userinfoMap = ThreadLocalUtil.get();
            Integer userid = (Integer) userinfoMap.get("id");
            userPlanBean.setUserid(userid);
            int i = userPlanMapper.addUserPlan(userPlanBean);
            if(i>0){
                return true;
            }
            return false;
        }catch (Exception e){
            log.error(e.getMessage());
            return false;
        }



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
