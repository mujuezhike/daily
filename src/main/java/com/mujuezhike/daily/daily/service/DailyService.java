package com.mujuezhike.daily.daily.service;

import java.util.List;

import com.mujuezhike.daily.daily.entity.DailyBean;
import com.mujuezhike.daily.daily.entity.DailyBeanHistoryStatistics;

public interface DailyService {
	
	public DailyBean save(DailyBean dailyBean);
	
	public int arrangeDocuments(String filePath);
	
	public List<DailyBeanHistoryStatistics> getHistoryByDate(String date);

}
