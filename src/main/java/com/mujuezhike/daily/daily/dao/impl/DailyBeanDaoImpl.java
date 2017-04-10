package com.mujuezhike.daily.daily.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mujuezhike.daily.daily.dao.DailyBeanDao;
import com.mujuezhike.daily.daily.dao.map.DailyBeanMapper;
import com.mujuezhike.daily.daily.entity.DailyBean;

@Component
public class DailyBeanDaoImpl implements DailyBeanDao{
	
	@Autowired
	private DailyBeanMapper dailyBeanMapper;

	@Override
	public int insert(DailyBean record) {
		return dailyBeanMapper.insert(record);
	}

	@Override
	public List<DailyBean> selectBySearchBean(DailyBean record) {
		return dailyBeanMapper.selectBySearchBean(record);
	}

	@Override
	public DailyBean selectByPrimaryKey(String id) {
		return dailyBeanMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(DailyBean record) {
		return dailyBeanMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(DailyBean record) {
		return dailyBeanMapper.updateByPrimaryKey(record);
	}

}
