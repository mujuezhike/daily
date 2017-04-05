package com.mujuezhike.daily.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mujuezhike.daily.test.dao.RelatedBeanDao;
import com.mujuezhike.daily.test.entity.RelatedBean;
import com.mujuezhike.daily.test.service.RelatedBeanService;

@Component
public class RelatedBeanServiceImpl implements RelatedBeanService{
	
	@Autowired
	private RelatedBeanDao relatedBeanDao;

	@Override
	public int insert(RelatedBean record) {
		return relatedBeanDao.insert(record);
	}

}
