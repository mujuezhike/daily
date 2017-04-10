package com.mujuezhike.daily.daily.dao;

import java.util.List;

import com.mujuezhike.daily.daily.entity.DailyBean;

public interface DailyBeanDao {

    int insert(DailyBean record);

    List<DailyBean> selectBySearchBean(DailyBean record);
    
    DailyBean selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DailyBean record);

    int updateByPrimaryKey(DailyBean record);

}
