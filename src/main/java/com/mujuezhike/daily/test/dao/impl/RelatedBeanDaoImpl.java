package com.mujuezhike.daily.test.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mujuezhike.daily.test.dao.RelatedBeanDao;
import com.mujuezhike.daily.test.dao.map.RelatedBeanMapper;
import com.mujuezhike.daily.test.entity.RelatedBean;

@Component
public class RelatedBeanDaoImpl implements RelatedBeanDao{

	@Autowired
	private RelatedBeanMapper relatedBeanMapper;

	@Override
	public int insert(RelatedBean record) {
		
		return relatedBeanMapper.insert(record);
	}

}
