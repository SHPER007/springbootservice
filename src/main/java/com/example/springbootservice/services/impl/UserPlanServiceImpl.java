package com.example.springbootservice.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.springbootservice.conf.utils.DateFormatUtil;
import com.example.springbootservice.conf.utils.SuperLanguage;
import com.example.springbootservice.conf.utils.ThreadLocalUtil;
import com.example.springbootservice.domain.params.UserPlanDtoParam;
import com.example.springbootservice.domain.po.UserPlan;
import com.example.springbootservice.domain.po.UserPlanBean;
import com.example.springbootservice.domain.responsevo.LanguageVo;
import com.example.springbootservice.domain.responsevo.UserPlanResDto;
import com.example.springbootservice.mapper.UserPlanMapper;
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

    /**
     *Params:[]
     *Return:com.example.springbootservice.domain.responsevo.UserPlanVo
     *Description: 获取用户当日计划详情
     */
    @Override
    public UserPlanResDto getUserPlan() {
        Integer userid= ThreadLocalUtil.get();
        List<Long> utcStartAndEndTimeStamp = DateFormatUtil.getUtcStartAndEndTimeStamp();
        LambdaQueryWrapper<UserPlan> selectUserPlanWrapper = new LambdaQueryWrapper<UserPlan>().
                eq(UserPlan::getUserid, userid)
                .between(UserPlan::getStartTime, utcStartAndEndTimeStamp.get(0), utcStartAndEndTimeStamp.get(1))
                .orderByAsc(UserPlan::getStartTime);
        List<UserPlan> userPlans = userPlanMapper.selectList(selectUserPlanWrapper);
        if(!userPlans.isEmpty()){
            setFormatTime(userPlans);
            LanguageVo LanguageVo = SuperLanguage.getSuperLanguage();
            UserPlanResDto userPlanResDtoVo = new UserPlanResDto();
            userPlanResDtoVo.setListPlan(userPlans);
            userPlanResDtoVo.setChinese(LanguageVo.getChinese());
            userPlanResDtoVo.setEnglish(LanguageVo.getEnglish());
            return userPlanResDtoVo;
        }
        return null;

    }

    /**
     *Params:[userPlanDtoParam]
     *Return:java.lang.Boolean
     *Description: 添加用户计划接口
     */

    @Override
    public Boolean createUserPlan(UserPlanDtoParam userPlanDtoParam) {
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
            int i = userPlanMapper.createUserPlan(userPlanBean);
            if(i < 0){
                log.info("creat UserPlan fail");
            }
            return i > 0;
        }catch (Exception e){
            log.error(e.getMessage());
            return false;
        }
    }
    /**
     *Params:[]
     *Return:java.lang.Boolean
     *Description:清空用户当日计划详情
     */
    @Override
    public Boolean clearUserPlanForToday() {
        Integer userid = ThreadLocalUtil.get();
        List<Long> utcStartAndEndTimeStamp = DateFormatUtil.getUtcStartAndEndTimeStamp();
        LambdaQueryWrapper<UserPlan> selectUserPlanWrapper = new LambdaQueryWrapper<UserPlan>().
                eq(UserPlan::getUserid, userid)
                .between(UserPlan::getStartTime, utcStartAndEndTimeStamp.get(0), utcStartAndEndTimeStamp.get(1));
        int delete = userPlanMapper.delete(selectUserPlanWrapper);
        if(delete <= 0){
            log.info("delete UserPlan fail");
            return false;
        }
        return true;
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
