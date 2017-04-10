package com.mujuezhike.daily.daily.dao.map;

import java.util.List;

import com.mujuezhike.daily.daily.entity.DailyBeanHistoryStatistics;

public interface DailyBeanHistoryStatisticsMapper {

    int insert(DailyBeanHistoryStatistics record);

    List<DailyBeanHistoryStatistics> selectBySearchBean(DailyBeanHistoryStatistics record);
    
    DailyBeanHistoryStatistics selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DailyBeanHistoryStatistics record);

    int updateByPrimaryKey(DailyBeanHistoryStatistics record);
    
    DailyBeanHistoryStatistics selectLastTitle(String title);
}
