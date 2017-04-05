package com.mujuezhike.daily.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mujuezhike.daily.test.dao.SearchBeanDao;
import com.mujuezhike.daily.test.entity.SearchBean;
import com.mujuezhike.daily.test.service.SearchBeanService;

@Component
public class SearchBeanServiceImpl implements SearchBeanService{
	
	@Autowired
	private SearchBeanDao searchBeanDao;

	@Override
	public int insert(SearchBean record) {
		return searchBeanDao.insert(record);
	}

}
