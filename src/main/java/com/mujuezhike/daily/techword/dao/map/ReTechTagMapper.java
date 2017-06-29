package com.mujuezhike.daily.techword.dao.map;

import java.util.List;

import com.mujuezhike.daily.techword.entity.ReTechTag;

public interface ReTechTagMapper {

	List<ReTechTag> selectByBean(ReTechTag bean);

}