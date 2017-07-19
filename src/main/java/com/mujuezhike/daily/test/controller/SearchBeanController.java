package com.mujuezhike.daily.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mujuezhike.daily.daily.entity.DailyBeanHistoryStatistics;
import com.mujuezhike.daily.daily.service.DailyService;
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
	
	@Autowired
	private DailyService dailyService;
	
	@RequestMapping("in")
	public ResponseEntity<ResultModel> in(SearchBean record){
		if(record.getName()!=null){
			searchBeanService.insert(record);
			return new ResponseEntity<>(ResultModel.ok(record), HttpStatus.OK);
		}
        return new ResponseEntity<>(ResultModel.error(ResultStatus.UNKNOWN_ERROR), HttpStatus.BAD_REQUEST);        
    }
	
	@RequestMapping("da")
	public ResponseEntity<ResultModel> da(String path){
		if(path!=null){
			dailyService.arrangeDocuments(path);
			return new ResponseEntity<>(ResultModel.ok("OK"), HttpStatus.OK);
		}
        return new ResponseEntity<>(ResultModel.error(ResultStatus.UNKNOWN_ERROR), HttpStatus.BAD_REQUEST);        
    }
	
	@RequestMapping("ca")
	public ResponseEntity<ResultModel> ca(String date){
		if(date!=null){
			List<DailyBeanHistoryStatistics> list = dailyService.getHistoryByDate(date);
			return new ResponseEntity<>(ResultModel.ok(list), HttpStatus.OK);
		}
        return new ResponseEntity<>(ResultModel.error(ResultStatus.UNKNOWN_ERROR), HttpStatus.BAD_REQUEST);        
    }
	
	@RequestMapping("ge")
	public ResponseEntity<ResultModel>ge(SearchBean record){
		if(record.getName()!=null){
			//webSpiderService.generateSearchBean(record.getName());
			int i=0;
			while(true){
				
//				int l = NormalCharTest.str.length();
//				
//				System.out.println(l);
//				
//				Random rd = new Random();
//				
//				String a = "";
//				
//				for(int i=0;i<3;i++){
//					
//					int u = rd.nextInt();
//					
//					int n = Math.abs(u%l);
//					
//					System.out.println(n);
//					
//					System.out.println(NormalCharTest.str.charAt(n));
//					
//					a += NormalCharTest.str.charAt(n);
//					
//				}
				
				String[] searchbean = {
						   "ActiveMQ"
						  ,"alibaba"
			              ,"amaze"
					      ,"amaze ui"
					      
						  ,"android"
						  ,"android studo"
						  ,"anglur"
						  ,"anglur.js"
						  
						  ,"annotate"
						  ,"AI"
						  ,"alexa"
						  ,"Ajax"
						  ,"AOP"
						  ,"Apache"
						  ,"api"
						  ,"app"
						  ,"Autowired"
					      ,"Axure"
					      ,"bootstrap"
						  ,"Cassandra"
						  ,"ccleaner"
			              ,"checkbox"
			              ,"chrome"
			              ,"Cipher"
			              ,"Cmd"
			              ,"Cmder"
			              ,"cms"
			              ,"cmstop"
			              ,"cocos2dx"
			              
			              ,"cShare"
						  ,"css"
						  ,"css3"
						  ,"css hack"
						  ,"CoreNLP"
						  ,"cubeweb"
						  ,"curared"
						  ,"c++"
						  ,"dataTables"
						  ,"DI"
						  
						  ,"dingdone"
						  ,"div"
						  ,"docker"
						  ,"DOM"
						  ,"DreamWeaver"
						  ,"dropdown"
						  ,"druid"
						  ,"dubbo"
						  ,"easyrules"
						  ,"EasyUI"
						  ,"eclipse"
						  ,"ecsd"
						  ,"emulator"
						  ,"epub"
						  ,"ETL"
						  ,"ERP"
						  ,"excel"
						  ,"extract"
						  ,"ffmpeg"
						  ,"Flux"
						  ,"fontawesome"
						  ,"freemarker"
						  ,"gem"
						  ,"Git"
						  ,"GitBash"
						  ,"gitblit"
						  ,"github"
						  ,"GitKraken"
						  ,"gradle"
						  ,"grails"
						  ,"Grizzly"
						  ,"gulp"
						  ,"H2"
						  ,"HAXM"
						  ,"Hbuilder"
						  ,"Hdata"
						  ,"hibernate"
						  ,"homebrew"
						  ,"hover"
						  ,"hplus"
						  ,"html"
						  ,"HTML5"
						  ,"hui"
						  ,"h+"
						  ,"iconfont"
						  ,"idea"
						  ,"iframe"
						  ,"icheck"
						  
						  ,"innodb"
						  ,"IOC"
						  ,"Ionic"
						  ,"iscroll"
						  ,"j2ee"
						  ,"java"
						  ,"javaee"
						  ,"javascript"
						  ,"javase"
						  ,"javassist"
						  
						  ,"javame"
						  ,"JBoss"
						  ,"JBPM"
						  ,"JDBC"
						  ,"jdi"
						  ,"jetbrain"
						  ,"jquery"
						  ,"jQueryeasyUI"
						  ,"js"
						  ,"json"
						  ,"JSP"
						  ,"JSX"
						  ,"junit"
						  ,"Kafka"
						  ,"kaggle"
						  ,"kendo"
						  ,"Kettle"
						  ,"LBS"
						  ,"LESS"
						  ,"linux"
						  ,"lisense"
						  ,"lodash"
						  ,"mac"
						  ,"mauna"
						  ,"maven"
						  ,"memcache"
						  ,"Mina"
						  ,"mikecrm"
						  ,"mongodb"
						  ,"mybatis"
						  ,"mybatis generator"
						  ,"myeclipse"
						  ,"mysql"
						  ,"navicat"
						  ,"Navicat Premium"
						  ,"Netty"
						  ,"nginx"
						  ,"NIO"
						  ,"Office"
						  ,"OLEDC ETL"
						  ,"omniGraffle"
						  ,"OpenCV"
						  ,"opentab"
						  ,"Oracle"
						  ,"periscope"
						   
						  ,"perl"
						  ,"photoshop"
						  ,"phoneGap"
						  ,"php"
						  ,"phpstorm"
						  ,"plsql"
						  ,"pl/sql"
						  ,"pl sql"
						  ,"powerdesigner"
						  ,"projecteuler"
						  ,"pycharm"
						  ,"python"
						  ,"quartz"
						  ,"RabbitMQ"
						  ,"React"
						  ,"redis"
						  ,"Redux"
						  ,"RSA"
						  ,"Ruby"
						  ,"SASS"
						  ,"SCSS"
						  ,"ScyllaDB"
						  ,"Servlet"
						  ,"shadowsocks"
						  ,"shadowsocksX"
						  ,"shiro"
						  ,"SLF4J"
						  ,"SourceTree"
						  ,"spring"
						  ,"springboot"
						  ,"springcloud"
						  ,"SpringMVC"
						  ,"sql"
						  ,"sqlserver"
						  ,"sql server"
						  ,"ssh"
						  ,"ssm"
						  ,"stack overflow"
						  ,"STARUML"
						  
						  ,"strtotime"
						  ,"struts"
						  ,"Struts2"
						  ,"sts"
						  ,"sublime"
						  ,"SuperSlide"
						  ,"Svn"
						  ,"swagger"
						  ,"swiper"
						  ,"theano"
						  ,"tk"
						  ,"tk.mybatis"
						  ,"tomcat"
						  ,"tooltip"
						  ,"TrelloCSS"
						  ,"TtlTransformer"
						  ,"twitch"
						  ,"Ubuntu"
						  ,"UML"
						  ,"unity"
						  ,"validate"
						  ,"velocity"
						  ,"verilog"
						  ,"viewerjs"
						  ,"VPS"
						  ,"vue"
						  ,"wap"
						  ,"webbench"
						  ,"WebLogic"
						  ,"webpack"
						  ,"WebStorm"
						  ,"wiki"
						  ,"xml"
						  ,"yum"
						  ,"zend"
						  ,"Zepto"
						  ,"ZeroMQ"
						  ,"Zookeeper"
						  ,"Ztree"
						  };
				
				System.out.println(searchbean[i]);
				
				webSpiderService.generateSearchBean(searchbean[i]);
				i++;
				if(i>=searchbean.length){
					break;
				}
				
			}
			
			//return new ResponseEntity<>(ResultModel.ok(record), HttpStatus.OK);
		}
        return new ResponseEntity<>(ResultModel.error(ResultStatus.UNKNOWN_ERROR), HttpStatus.BAD_REQUEST);        
    }

}
