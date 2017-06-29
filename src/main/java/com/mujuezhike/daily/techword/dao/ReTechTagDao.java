package com.mujuezhike.daily.techword.dao;

import java.util.List;

import com.mujuezhike.daily.techword.entity.ReTechTag;

public interface ReTechTagDao {
    
	List<ReTechTag> selectByBean(ReTechTag id);

}
