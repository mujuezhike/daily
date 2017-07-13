package com.mujuezhike.daily.techword.service;

import java.util.List;

import com.mujuezhike.daily.techword.entity.ReTechTag;
import com.mujuezhike.daily.techword.entity.vo.ReTechTagWithWord;

public interface ReTechTagService {
	
	List<ReTechTag> selectByBean(ReTechTag bean);
	
	List<ReTechTagWithWord> selectTagForBean(ReTechTag bean);
	
	List<ReTechTagWithWord> selectPropertyForBean(ReTechTag bean);

}
