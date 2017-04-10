package com.mujuezhike.daily.daily.dao;

import java.util.List;

import com.mujuezhike.daily.daily.entity.DailyBeanHistoryStatistics;

public interface DailyBeanHistoryStatisticsDao {

    int insert(DailyBeanHistoryStatistics record);

    List<DailyBeanHistoryStatistics> selectBySearchBean(DailyBeanHistoryStatistics record);
    
    DailyBeanHistoryStatistics selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DailyBeanHistoryStatistics record);

    int updateByPrimaryKey(DailyBeanHistoryStatistics record);
    
    DailyBeanHistoryStatistics selectLastTitle(String title);

}
