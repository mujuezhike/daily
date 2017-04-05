package com.mujuezhike.daily.test.dao;

import java.util.List;

import com.mujuezhike.daily.test.entity.SearchBean;

public interface SearchBeanDao {
	
	int deleteByPrimaryKey(Long id);

    int insert(SearchBean record);

    List<SearchBean> selectBySearchBean(SearchBean searchBean);
    
    SearchBean selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SearchBean record);

    int updateByPrimaryKey(SearchBean record);

}
