package com.mujuezhike.daily.daily.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mujuezhike.daily.daily.dao.DailyBeanHistoryStatisticsDao;
import com.mujuezhike.daily.daily.dao.map.DailyBeanHistoryStatisticsMapper;
import com.mujuezhike.daily.daily.entity.DailyBeanHistoryStatistics;

@Component
public class DailyBeanHistoryStatisticsDaoImpl implements DailyBeanHistoryStatisticsDao{
	
	@Autowired
	private  DailyBeanHistoryStatisticsMapper  dailyBeanHistoryStatisticsMapper;

	@Override
	public int insert( DailyBeanHistoryStatistics record) {
		return dailyBeanHistoryStatisticsMapper.insert(record);
	}

	@Override
	public List<DailyBeanHistoryStatistics> selectBySearchBean(DailyBeanHistoryStatistics record) {
		return dailyBeanHistoryStatisticsMapper.selectBySearchBean(record);
	}

	@Override
	public DailyBeanHistoryStatistics selectByPrimaryKey(String id) {
		return dailyBeanHistoryStatisticsMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(DailyBeanHistoryStatistics record) {
		return dailyBeanHistoryStatisticsMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(DailyBeanHistoryStatistics record) {
		return dailyBeanHistoryStatisticsMapper.updateByPrimaryKey(record);
	}

	@Override
	public DailyBeanHistoryStatistics selectLastTitle(String title) {
		return dailyBeanHistoryStatisticsMapper.selectLastTitle(title);
	}

}
