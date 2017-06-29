package com.mujuezhike.daily.techword.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mujuezhike.daily.techword.dao.ETechWordDao;
import com.mujuezhike.daily.techword.dao.map.ETechWordMapper;
import com.mujuezhike.daily.techword.entity.ETechWord;

@Component
public class ETechWordDaoImpl implements ETechWordDao{

	@Autowired
	private ETechWordMapper eTechWordMapper;
	
	
	@Override
	public ETechWord selectByPrimaryKey(Long id) {
		
		return eTechWordMapper.selectByPrimaryKey(id);
		
	}

}
