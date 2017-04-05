package com.mujuezhike.daily.test.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mujuezhike.daily.test.dao.SearchBeanDao;
import com.mujuezhike.daily.test.dao.map.SearchBeanMapper;
import com.mujuezhike.daily.test.entity.SearchBean;

@Component
public class SearchBeanDaoImpl implements SearchBeanDao{

	@Autowired
	private SearchBeanMapper searchBeanMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		
		return searchBeanMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SearchBean record) {
		
		return searchBeanMapper.insert(record);
	}

	@Override
	public SearchBean selectByPrimaryKey(Long id) {
		
		return searchBeanMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(SearchBean record) {
		
		return searchBeanMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SearchBean record) {
		
		return searchBeanMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<SearchBean> selectBySearchBean(SearchBean searchBean) {
		
		return searchBeanMapper.selectBySearchBean(searchBean);
		
	}
	
	

}
