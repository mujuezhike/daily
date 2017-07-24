package com.mujuezhike.daily;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import com.mujuezhike.daily.DailyTest.ValueComparator;

public class ResumeSearchTest {

	public static long mainnum = 0;
	

	public static Map<String,Long> typeMap = new HashMap<String,Long>();
	public static List<String> typeList = new ArrayList<String>();
	public static ValueComparator bvc =  new ValueComparator(typeMap);  
	public static Map<String,Long> sorted_map = new TreeMap<String,Long>(bvc);
	
	public static Map<String,Long> nameMap = new HashMap<String,Long>();
	public static ValueComparator nvc =  new ValueComparator(nameMap);  
	public static Map<String,Long> sorted_name_map = new TreeMap<String,Long>(nvc);
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		String[] searchbean = {"spring"
//							  ,"solr"
//							  ,"mysql"
//							  ,"sqlserver"
//							  ,"oracle"
//							  ,"redis"
//							  ,"jquery"
//							  ,"java"
//							  ,"struts"
//							  ,"hibernate"
//							  ,"c++"
//							  ,"python"
//							  ,"activiti"
//							  ,"hbase"
//							  ,"ehcache"
//							  ,"php"
//							  ,"html"
//							  ,"js"
//							  ,"css"
//							  ,"hornetq"
//							  ,"jenkins"
//							  ,"canal"
//							  ,"dubbo"
//							  ,"elasticsearch"
//							  ,"cassandra"
//							  ,"springcloud"
//							  ,"hadoop"
//							  ,"stack overflow"
//							  ,"cocos2dx"};
		//20160804
		//
//		String[] searchbean = {
//				   "ActiveMQ"
//				  ,"alibaba"
//	              ,"amaze"
//			      ,"amaze ui"
//			      
//				  ,"android"
//				  ,"android studo"
//				  ,"anglur"
//				  ,"anglur.js"
//				  ,"angular"
//				  ,"angularjs"
//				  ,"angular.js"
//				  ,"annotate"
//				  ,"AI"
//				  ,"alexa"
//				  ,"Ajax"
//				  ,"AOP"
//				  ,"Apache"
//				  ,"api"
//				  ,"app"
//				  ,"Applet"
//				  ,"Autowired"
//			      ,"Axure"
//			      ,"bootstrap"
//			      ,"B/S"
//			      ,"C3P0"
//			      ,"Cassandra"
//				  ,"ccleaner"
//	              ,"checkbox"
//	              ,"chrome"
//	              ,"Cipher"
//	              ,"Cmd"
//	              ,"Cmder"
//	              ,"cms"
//	              ,"cmstop"
//	              ,"cocos2dx"
//	              
//	              ,"cShare"
//				  ,"css"
//				  ,"css3"
//				  ,"css hack"
//				  ,"COA"
//				  ,"CORBA"
//				  ,"CoreNLP"
//				  ,"cubeweb"
//				  ,"curared"
//				  ,"c++"
//				  ,"C/S"
//				  ,"dataTables"
//				  ,"DI"
//				  
//				  ,"dingdone"
//				  ,"div"
//				  ,"docker"
//				  ,"DOM"
//				  ,"dom4j"
//				  ,"DreamWeaver"
//				  ,"dropdown"
//				  ,"druid"
//				  ,"dubbo"
//				  ,"EAI"
//				  ,"easyrules"
//				  ,"EasyUI"
//				  ,"ECharts"
//				  ,"eclipse"
//				  ,"ecsd"
//				  ,"EL"
//				  ,"emulator"
//				  ,"epub"
//				  ,"ETL"
//				  ,"ERP"
//				  ,"ESB"
//				  ,"excel"
//				  ,"extract"
//				  ,"ffmpeg"
//				  ,"Flux"
//				  ,"fontawesome"
//				  ,"freemarker"
//				  ,"gem"
//				  ,"Git"
//				  ,"GitBash"
//				  ,"gitblit"
//				  ,"github"
//				  ,"GitKraken"
//				  ,"gradle"
//				  ,"grails"
//				  ,"Grizzly"
//				  ,"gulp"
//				  ,"H2"
//				  ,"HAXM"
//				  ,"Hbuilder"
//				  ,"Hdata"
//				  ,"hibernate"
//				  ,"homebrew"
//				  ,"hover"
//				  ,"hplus"
//				  ,"html"
//				  ,"HTML5"
//				  ,"hui"
//				  ,"h+"
//				  ,"iBATIS"
//				  ,"icheck"
//				  ,"iconfont"
//				  ,"IDE"
//				  ,"idea"
//				  ,"iframe"
//				  
//				  
//				  ,"innodb"
//				  ,"IOC"
//				  ,"Ionic"
//				  ,"iscroll"
//				  ,"j2ee"
//				  ,"JAAS"
//				  ,"java"
//				  ,"JavaBean"
//				  ,"javaee"
//				  ,"javascript"
//				  ,"javase"
//				  ,"javassist"
//				  ,"JavaMail"
//				  ,"javame"
//				  ,"JBoss"
//				  ,"JBossAS"
//				  ,"JBossWeb"
//				  ,"JBPM"
//				  ,"JCA"
//				  ,"JDBC"
//				  ,"JDK"
//				  ,"jdi"
//				  ,"jetbrain"
//				  ,"Jetty"
//				  ,"JMS"
//				  ,"JNDI"
//				  ,"jquery"
//				  ,"jQueryeasyUI"
//				  ,"js"
//				  ,"JSF"
//				  ,"JSF EL"
//				  ,"json"
//				  ,"JSP"
//				  ,"JSTL"
//				  ,"JSX"
//				  ,"JTA"
//				  ,"junit"
//				  ,"jvm"
//				  ,"Kafka"
//				  ,"kaggle"
//				  ,"kendo"
//				  ,"Kettle"
//				  ,"LBS"
//				  ,"LESS"
//				  ,"linux"
//				  ,"lisense"
//				  ,"lodash"
//				  ,"log4j"
//				  ,"mac"
//				  ,"mauna"
//				  ,"maven"
//				  ,"memcache"
//				  ,"metronic"
//				  ,"Mina"
//				  ,"mikecrm"
//				  ,"mongodb"
//				  ,"MVC"
//				  ,"mybatis"
//				  ,"mybatis generator"
//				  ,"myeclipse"
//				  ,"mysql"
//				  ,"navicat"
//				  ,"Navicat Premium"
//				  ,"Netty"
//				  ,"nginx"
//				  ,"NIO"
//				  ,"NoSQL"
//				  ,"Office"
//				  ,"OLEDC ETL"
//				  ,"omniGraffle"
//				  ,"OpenCV"
//				  ,"opentab"
//				  ,"Oracle"
//				  ,"OSGI"
//				  ,"periscope"
//				   
//				  ,"perl"
//				  ,"photoshop"
//				  ,"phoneGap"
//				  ,"php"
//				  ,"phpstorm"
//				  ,"plsql"
//				  ,"pl/sql"
//				  ,"pl sql"
//				  ,"poi"
//				  ,"powerdesigner"
//				  ,"projecteuler"
//				  ,"pycharm"
//				  ,"python"
//				  ,"quartz"
//				  ,"RabbitMQ"
//				  
//				  ,"React"
//				  
//				  ,"redis"
//				  ,"Redux"
//				  ,"RESI"
//				  ,"Resin"
//				  ,"restful"
//				  ,"RMI"
//				  ,"ROA"
//				  ,"RSA"
//				  ,"Ruby"
//				  ,"SaaS"
//				  ,"SASS"
//				  ,"SCA"
//				  ,"SCSS"
//				  ,"ScyllaDB"
//				  ,"Servlet"
//				  ,"shadowsocks"
//				  ,"shadowsocksX"
//				  ,"shiro"
//				  ,"Sitemesh"
//				  ,"SLF4J"
//				  ,"SOA"
//				  ,"Socket"
//				  ,"SourceTree"
//				  ,"spring"
//				  ,"springboot"
//				  ,"springcloud"
//				  ,"SpringMVC"
//				  ,"sql"
//				  ,"sqlserver"
//				  ,"sql server"
//				  ,"ssh"
//				  ,"ssm"
//				  ,"stack overflow"
//				  ,"STARUML"
//				  ,"stringbuffer"
//				  ,"strtotime"
//				  ,"struts"
//				  ,"Struts2"
//				  ,"sts"
//				  ,"sublime"
//				  ,"SuperSlide"
//				  ,"Svn"
//				  ,"swagger"
//				  ,"swiper"
//				  ,"Taglib"
//				  ,"tcp"
//				  ,"theano"
//				  ,"tk"
//				  ,"tk.mybatis"
//				  ,"tomcat"
//				  ,"tooltip"
//				  ,"TrelloCSS"
//				  ,"TtlTransformer"
//				  ,"twitch"
//				  ,"Ubuntu"
//				  ,"udp"
//				  ,"UML"
//				  ,"unity"
//				  ,"validate"
//				  ,"velocity"
//				  ,"verilog"
//				  ,"viewerjs"
//				  ,"VPS"
//				  ,"vue"
//				  ,"wap"
//				  ,"webbench"
//				  ,"WebLogic"
//				  ,"webpack"
//				  ,"WebService"
//				  ,"WebSphere"
//				  ,"WebStorm"
//				  ,"wiki"
//				  ,"xml"
//				  ,"yum"
//				  ,"zend"
//				  ,"Zepto"
//				  ,"ZeroMQ"
//				  ,"Zookeeper"
//				  ,"Ztree" 
//				  ,"阿里大于"
//				  ,"支付宝"
//				  ,"微信"
//				  };
		
		String[] searchbean = {
				 "AWS"
				,"JDBC"
				,"Hystrix"
				,"DashBoard"
				,"Turbine"
				,"Spring Boot"
				,"Spring Cloud"
				,"Spring Config"
				,"Consul"
				,"Vault"
				,"Zookeeper"
				,"Contract"
				,"Verifer"
				,"Stub Runner"
				,"WireMock"
				,"Connectors"
				,"BootStrap"
				,"Security"
				,"Oauth2"
				,"Task"
				,"Discovery"
				,"Eureka"
				,"Zookeeper"
				,"Foundry"
				,"Consul"
				,"AMQP"
				,"Kafka"
				,"Rabbit"
				,"Routing"
				,"Zuul"
				,"Ribbon"
				,"Feign"
				,"Tracing"
				,"Sleuth"
				,"Zipkin"
				,"AOP"
				,"Atomikos"
				,"Bitronix"
				,"Narayana"
				,"Cache"
				,"DevTools"
				,"Processer"
				,"Validation"
				,"Session"
				,"Retry"
				,"JTA"
				,"I/O"
				,"Lombok"
				,"Batch"
				,"Integration"
				,"Quartz"
				,"Scheduler"
				,"Activity"
				,"Camel"
				,"ActiveMQ"
				,"Artemis"
				,"JMS"
				,"HornetQ"
				,"AMQP"
				,"Kafka"
				,"Mail"
				,"LDAP"
				,"NoSQL"
				,"MongoDB"
				,"Embedded"
				,"Reactive"
				,"Cassandra"
				,"Couchbase"
				,"Neo4j"
				,"Redis"
				,"Gemfire"
				,"Solr"
				,"ElasticSearch"
				,"Ops"
				,"Actuator"
				,"Docs"
				,"Remote"
				,"Shell"
				,"Pivotal"
				,"Cloud"
				,"Regissty"
				,"Foundry"
				,"PCF"
				,"Circuit"
				,"Breaker"
				,"SQL"
				,"JPA"
				,"JOOQ"
				,"MyBatis"
				,"JDBC"
				,"H2"
				,"HSQLDB"
				,"Derby"
				,"Apache"
				,"MySQL"
				,"PostgreSQL"
				,"SQL Server"
				,"Flyway"
				,"Liquibase"
				,"Social"
				,"Facebook"
				,"Linkedln"
				,"Twitter"
				,"Template"
				,"FreeMarker"
				,"Velocity"
				,"Groovy"
				,"Thymeleaf"
				,"Mustache"
				,"Websocket"
				,"Web Services"
				,"Jersey"
				,"CXF"
				,"JAX-RS"
				,"Ratpack"
				,"Vaadin"
				,"Rest"
				,"Repositories"
				,"HATEOAS"
				,"HAL"
				,"Mobile"
				,"Stormpath"
				,"Keycloak"
	
		};
		
		for(int i=0;i<searchbean.length;i++){
			mainnum = 0;
			traverseFolder("G:\\代码资料\\jl",searchbean[i]);
			System.out.println(searchbean[i]+": "+mainnum);
			typeMap.put(searchbean[i],mainnum);
        	
		}
		
		System.out.println("=============================================================================================");
		sorted_map.putAll(typeMap); 

		showTreeMap(sorted_map);
		
		sorted_name_map.putAll(nameMap); 

		showTreeMap(sorted_name_map);

	}
	
	

	public static void traverseFolder(String path,String searchBean) throws IOException {
		
		File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files.length == 0) {
                //System.out.println("file not find!");
                return;
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                    	
                    	traverseFolder(file2.getAbsolutePath(),searchBean);
                    	
                    } else {
                    	
                    	String fileName = file2.getName();
                    	
//                    	if(file2.getName().contains(searchBean)){
//                    		System.out.println("filename "+ file2.getAbsolutePath() +": title ");
//                    	}

                    	//if(file2.getName().contains(".htm")){
//                    		String s = file2.getName();
//                    		if(s.contains("51job_")){
//                    			s = s.substring(6);
//                    		};
//                    		if(s.contains("_")){
//                    			s = s.substring(0, s.indexOf("_"));
//                    		}
//                    		if(s.contains(".")){
//                    			s = s.substring(0, s.indexOf("."));
//                    		}
//                    		
//                    		File filekk = new File("C:/简历file/"+s);
//                    		copyFile(file2,filekk);
                    		searchFileByLines(file2,searchBean);
                    	//}
                    }
                }
            }
        } else {
            System.out.println("文件路径不存在!");
        }
	}
	
    public static void searchFileByLines(File file,String searchBean) {
        BufferedReader reader = null;
        try {
            
        	reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),getCharset(file)));    
            String tempString = null;
            int line = 1;
            
            while ((tempString = reader.readLine()) != null) {
                
            	if(tempString.toLowerCase().contains(searchBean.toLowerCase())){
            		//System.out.println("filename "+ file.getAbsolutePath() +": line " + line + ": " + tempString);
            		mainnum++;
            		
            		Long count = nameMap.get(file.getName());
                	if(count==null){
                		nameMap.put(file.getName(),1l);
                	}else{
                		nameMap.put(file.getName(),count+1);
                	}
            		return;
            	}
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                	e1.printStackTrace();
                }
            }
        }
    }
    
    /**
     * 获取指定文件编码  
     * @param file
     * @return
     * @throws IOException
     */
    public static String getCharset(File file) throws IOException{  
        
        BufferedInputStream bin = new BufferedInputStream(new FileInputStream(file));    
        int p = (bin.read() << 8) + bin.read();    
          
        String code = null;    
          
        switch (p) {    
            case 0xefbb:    
                code = "UTF-8";    
                break;    
            case 0xfffe:    
                code = "Unicode";    
                break;    
            case 0xfeff:    
                code = "UTF-16BE";    
                break;    
            default:    
                code = "GBK";    
        }    
        return code;  
	 }
    
    /**
     * 复制文件
     * @param fromFile
     * @param toFile
     * <br/>
     * 2016年12月19日  下午3:31:50
     * @throws IOException 
     */
    public static void copyFile(File fromFile,File toFile) throws IOException{
        FileInputStream ins = new FileInputStream(fromFile);
        FileOutputStream out = new FileOutputStream(toFile);
        byte[] b = new byte[1024];
        int n=0;
        while((n=ins.read(b))!=-1){
            out.write(b, 0, b.length);
        }
        
        ins.close();
        out.close();
    }

    private static void showTreeMap(Map<String, Long> map) {

	    for (Entry<String, Long> en : map.entrySet()) {
	    	
	    	System.out.println(en.getKey() + "  :  " + en.getValue());
            
	    }
		
	}
    
}
