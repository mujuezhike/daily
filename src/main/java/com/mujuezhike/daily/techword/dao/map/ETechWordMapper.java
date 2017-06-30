package com.mujuezhike.daily.techword.dao.map;

import com.mujuezhike.daily.techword.entity.ETechWord;

public interface ETechWordMapper {

	ETechWord selectByPrimaryKey(Long id);
	
	int addBean(ETechWord bean);

}