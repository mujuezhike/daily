package com.mujuezhike.daily.test.dao.map;

import java.util.List;

import com.mujuezhike.daily.test.entity.SearchBean;

public interface SearchBeanMapper {
	
    int deleteByPrimaryKey(Long id);

    int insert(SearchBean record);
    
    List<SearchBean> selectBySearchBean(SearchBean searchBean);

    SearchBean selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SearchBean record);

    int updateByPrimaryKey(SearchBean record);
}