package com.mujuezhike.daily.techword.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mujuezhike.daily.techword.entity.ETechWord;
import com.mujuezhike.daily.techword.entity.ReTechTag;
import com.mujuezhike.daily.techword.entity.vo.ReTechTagWithWord;
import com.mujuezhike.daily.techword.enums.OPTypeEnum;
import com.mujuezhike.daily.techword.service.ETechWordService;
import com.mujuezhike.daily.techword.service.ReTechTagService;
import com.mujuezhike.daily.test.entity.ResultModel;

@Controller
@RequestMapping("/techword/")
public class ETechWordController {
	
	@Autowired
	private ETechWordService eTechWordService;
	
	@Autowired
	private ReTechTagService reTechTagService;
	
	@RequestMapping("detail")
	public ResponseEntity<ResultModel> detail(ETechWord record){
		
		ETechWord detail = eTechWordService.selectByPrimaryKey(record.getId());
		
		return new ResponseEntity<>(ResultModel.ok(detail), HttpStatus.OK);
		
    }
	
	@RequestMapping("save")
	public ResponseEntity<ResultModel> save(ETechWord record){
		
		OPTypeEnum opt = OPTypeEnum.ADD;
		
		Long id = record.getId();
		if(id != null && id > 0 ){
			
			ETechWord detail = eTechWordService.selectByPrimaryKey(record.getId());
			if(detail!= null && detail.getId()!=null && detail.getId() > 0 ){
			
				opt = OPTypeEnum.EDIT;
				
			}else{
				
				opt = OPTypeEnum.ADD;
				
			}
			
		}else{
			
			opt = OPTypeEnum.ADD;
			
		}
		
		if(opt == OPTypeEnum.ADD){
			
			eTechWordService.addBean(record);
			
		}else{
			
			record = new ETechWord();
			
		}
		
		return new ResponseEntity<>(ResultModel.ok(record), HttpStatus.OK);
		
    }
	
	@RequestMapping("tag")
	public ResponseEntity<ResultModel> tag(ETechWord record){
		
		ReTechTag bean = new ReTechTag();
		
		bean.setTargetWord(record.getId());
		
		List<ReTechTag> list = reTechTagService.selectByBean(bean);
		
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
		
		return new ResponseEntity<>(ResultModel.ok(rlist), HttpStatus.OK);
		
    }

	
	@RequestMapping("related")
	public ResponseEntity<ResultModel> related(ETechWord record){
		
		ReTechTag bean = new ReTechTag();
		
		bean.setTagWord(record.getId());
		
		List<ReTechTag> list = reTechTagService.selectByBean(bean);
		
		List<ReTechTagWithWord> rlist = new ArrayList<ReTechTagWithWord>();
		
		for(int i=0;i<list.size();i++){
			
			ReTechTag listbean = list.get(i);
			
			ReTechTagWithWord rbean = new ReTechTagWithWord();
			
			BeanUtils.copyProperties(listbean, rbean);
			
			if(listbean!=null){
				
				//tagWord
				Long targetWord = listbean.getTargetWord();
				
				if(targetWord!=null && targetWord > 0){
					
					ETechWord targetWordBean = eTechWordService.selectByPrimaryKey(targetWord);
					
					rbean.setTargetWordBean(targetWordBean);
					
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
		
		return new ResponseEntity<>(ResultModel.ok(rlist), HttpStatus.OK);
		
	}
}
