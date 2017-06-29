package com.mujuezhike.daily.techword.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mujuezhike.daily.techword.dao.ReTechTagDao;
import com.mujuezhike.daily.techword.entity.ReTechTag;
import com.mujuezhike.daily.techword.service.ReTechTagService;

@Component
public class ReTechTagServiceImpl implements ReTechTagService{
	
	@Autowired
	private ReTechTagDao reTechTagDao;

	@Override
	public List<ReTechTag> selectByBean(ReTechTag bean) {
		
		return reTechTagDao.selectByBean(bean);
	
	}
	
}
