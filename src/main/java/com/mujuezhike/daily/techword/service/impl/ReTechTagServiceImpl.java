package com.mujuezhike.daily.techword.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mujuezhike.daily.techword.dao.ReTechTagDao;
import com.mujuezhike.daily.techword.entity.ETechWord;
import com.mujuezhike.daily.techword.entity.ReTechTag;
import com.mujuezhike.daily.techword.entity.vo.ReTechTagWithWord;
import com.mujuezhike.daily.techword.enums.IsPropertyEnum;
import com.mujuezhike.daily.techword.service.ETechWordService;
import com.mujuezhike.daily.techword.service.ReTechTagService;

@Component
public class ReTechTagServiceImpl implements ReTechTagService{
	
	@Autowired
	private ReTechTagDao reTechTagDao;
	
	@Autowired
	private ETechWordService eTechWordService;

	@Override
	public List<ReTechTag> selectByBean(ReTechTag bean) {
		
		return reTechTagDao.selectByBean(bean);
	
	}

	@Override
	public List<ReTechTagWithWord> selectTagForBean(ReTechTag record) {
		
		ReTechTag bean = new ReTechTag();
		
		bean.setTargetWord(record.getTargetWord());
		
		/** 设置  是否为   property **/
		bean.setIsProperty(IsPropertyEnum.IsNot.num());
		
		List<ReTechTag> list = selectByBean(bean);
		
		List<ReTechTagWithWord> rlist = new ArrayList<ReTechTagWithWord>();
		
		for(int i=0;i<list.size();i++){
			
			ReTechTag listbean = list.get(i);
			
			ReTechTagWithWord rbean = new ReTechTagWithWord();
			
			BeanUtils.copyProperties(listbean, rbean);
			
			if(listbean!=null){
				
				//tagWord
				Long tagWord = listbean.getTagWord();
				
				if(tagWord!=null && tagWord > 0){
					
					ETechWord tagWordBean = eTechWordService.selectByPrimaryKey(tagWord);
					
					rbean.setTagWordBean(tagWordBean);
					
				}
				
				//relatedWord
				Long relatedWord = listbean.getRelatedWord();
				
				if(relatedWord!=null && relatedWord > 0){
					
					ETechWord relatedWordBean = eTechWordService.selectByPrimaryKey(relatedWord);
					
					rbean.setRelatedWordBean(relatedWordBean);
					
				}
				
			}
			
			rlist.add(rbean);
		}
		
		return rlist;
	}

	@Override
	public List<ReTechTagWithWord> selectPropertyForBean(ReTechTag record) {
		
		ReTechTag bean = new ReTechTag();
		
		bean.setTargetWord(record.getTargetWord());
		
		/** 设置  是否为   property **/
		bean.setIsProperty(IsPropertyEnum.Is.num());
		
		List<ReTechTag> list = selectByBean(bean);
		
		List<ReTechTagWithWord> rlist = new ArrayList<ReTechTagWithWord>();
		
		for(int i=0;i<list.size();i++){
			
			ReTechTag listbean = list.get(i);
			
			ReTechTagWithWord rbean = new ReTechTagWithWord();
			
			BeanUtils.copyProperties(listbean, rbean);
			
			if(listbean!=null){
				
				//tagWord
				Long tagWord = listbean.getTagWord();
				
				if(tagWord!=null && tagWord > 0){
					
					ETechWord tagWordBean = eTechWordService.selectByPrimaryKey(tagWord);
					
					rbean.setTagWordBean(tagWordBean);
					
				}
				
				//relatedWord
				Long relatedWord = listbean.getRelatedWord();
				
				if(relatedWord!=null && relatedWord > 0){
					
					ETechWord relatedWordBean = eTechWordService.selectByPrimaryKey(relatedWord);
					
					rbean.setRelatedWordBean(relatedWordBean);
					
				}
				
			}
			
			rlist.add(rbean);
		}
		
		return rlist;
	}
	
}
