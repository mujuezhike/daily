package com.mujuezhike.daily.beancontent.service;

import java.util.List;

import com.mujuezhike.daily.beancontent.entity.BeanContent;

/**
 * 动态数据服务
 * @author mujuezhike
 */
public interface BeanContentService {

	public BeanContent addBeanContent(BeanContent bc);
	
	public BeanContent updateBeanContent(BeanContent bc);
	
	public BeanContent deleteBeanContent(BeanContent bc);
	
	public List<BeanContent> listBeanContent(BeanContent bc);
	
}
