package com.mujuezhike.daily.daily.dao.map;

import java.util.List;

import com.mujuezhike.daily.daily.entity.DailyBean;

public interface DailyBeanMapper {

	 int insert(DailyBean record);
	    
	 List<DailyBean> selectBySearchBean(DailyBean record);

	 DailyBean selectByPrimaryKey(String id);

	 int updateByPrimaryKeySelective(DailyBean record);

	 int updateByPrimaryKey(DailyBean record);

}
