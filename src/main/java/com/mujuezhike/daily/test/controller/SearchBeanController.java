package com.mujuezhike.daily.test.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mujuezhike.daily.NormalCharTest;
import com.mujuezhike.daily.test.entity.ResultModel;
import com.mujuezhike.daily.test.entity.SearchBean;
import com.mujuezhike.daily.test.enums.ResultStatus;
import com.mujuezhike.daily.test.service.SearchBeanService;
import com.mujuezhike.daily.webspider.service.WebSpiderService;

@Controller
@RequestMapping("/")
public class SearchBeanController {
	
	@Autowired
	private SearchBeanService searchBeanService;
	
	@Autowired
	private WebSpiderService webSpiderService;
	
	@RequestMapping("in")
	public ResponseEntity<ResultModel> in(SearchBean record){
		if(record.getName()!=null){
			searchBeanService.insert(record);
			return new ResponseEntity<>(ResultModel.ok(record), HttpStatus.OK);
		}
        return new ResponseEntity<>(ResultModel.error(ResultStatus.UNKNOWN_ERROR), HttpStatus.BAD_REQUEST);        
    }
	
	@RequestMapping("ge")
	public ResponseEntity<ResultModel>ge(SearchBean record){
		if(record.getName()!=null){
			webSpiderService.generateSearchBean(record.getName());
			
			while(true){
				
				int l = NormalCharTest.str.length();
				
				System.out.println(l);
				
				Random rd = new Random();
				
				String a = "";
				
				for(int i=0;i<3;i++){
					
					int u = rd.nextInt();
					
					int n = Math.abs(u%l);
					
					System.out.println(n);
					
					System.out.println(NormalCharTest.str.charAt(n));
					
					a += NormalCharTest.str.charAt(n);
					
				}
				
				System.out.println(a);
				
				webSpiderService.generateSearchBean(a);
				
			}
			
			//return new ResponseEntity<>(ResultModel.ok(record), HttpStatus.OK);
		}
        return new ResponseEntity<>(ResultModel.error(ResultStatus.UNKNOWN_ERROR), HttpStatus.BAD_REQUEST);        
    }

}
