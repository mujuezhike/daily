package com.mujuezhike.daily.techword.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mujuezhike.daily.techword.dao.ETechWordDao;
import com.mujuezhike.daily.techword.entity.ETechWord;
import com.mujuezhike.daily.techword.service.ETechWordService;

@Component
public class ETechWordServiceImpl implements ETechWordService{
	
	@Autowired
	private ETechWordDao eTechWordDao;


	@Override
	public ETechWord selectByPrimaryKey(Long id) {
		
		return eTechWordDao.selectByPrimaryKey(id);
	
	}

}
