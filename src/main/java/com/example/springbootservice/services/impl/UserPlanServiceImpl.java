package com.example.springbootservice.services.impl;

import com.example.springbootservice.conf.utils.DateFormatUtil;
import com.example.springbootservice.conf.utils.SuperLanguage;
import com.example.springbootservice.conf.utils.ThreadLocalUtil;
import com.example.springbootservice.mapper.UserPlanMapper;
import com.example.springbootservice.domain.po.UserPlan;
import com.example.springbootservice.domain.po.UserPlanBean;
import com.example.springbootservice.domain.params.UserPlanDtoParam;
import com.example.springbootservice.domain.responsevo.LanguageVoDto;
import com.example.springbootservice.domain.responsevo.UserPlanDtoVo;
import com.example.springbootservice.services.UserPlanService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
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
    public UserPlanDtoVo getUserPlan() {
        Integer userid= ThreadLocalUtil.get();
        List<UserPlan> userPlanList = userPlanMapper.getUserPlanList(userid);
        if(!userPlanList.isEmpty()){
            setFormatTime(userPlanList);
            LanguageVoDto LanguageVoDto = SuperLanguage.getSuperLanguage();
            UserPlanDtoVo userPlanDtoVo = new UserPlanDtoVo();
            userPlanDtoVo.setListPlan(userPlanList);
            userPlanDtoVo.setChinese(LanguageVoDto.getChinese());
            userPlanDtoVo.setEnglish(LanguageVoDto.getEnglish());
            return userPlanDtoVo;
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

            Integer userid = ThreadLocalUtil.get();
            userPlanBean.setUserid(userid);
            int i = userPlanMapper.addUserPlan(userPlanBean);
            if(i < 0){
                log.info("creat UserPlan fail");
            }
            return i > 0;
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
