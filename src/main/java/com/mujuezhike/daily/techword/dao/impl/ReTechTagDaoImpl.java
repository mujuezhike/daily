package com.mujuezhike.daily.techword.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mujuezhike.daily.techword.dao.ReTechTagDao;
import com.mujuezhike.daily.techword.dao.map.ReTechTagMapper;
import com.mujuezhike.daily.techword.entity.ReTechTag;

@Component
public class ReTechTagDaoImpl implements ReTechTagDao{

	@Autowired
	private ReTechTagMapper reTechTagMapper;

	@Override
	public List<ReTechTag> selectByBean(ReTechTag bean) {
		
		return reTechTagMapper.selectByBean(bean);
		
	}
	

}
