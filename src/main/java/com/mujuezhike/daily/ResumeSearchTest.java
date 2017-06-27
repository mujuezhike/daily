package com.mujuezhike.daily;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ResumeSearchTest {

	public static int mainnum = 0;
	
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
							  ,"gem"
							  ,"Git"
							  ,"GitBash"
							  ,"gitblit"
							  ,"github"
							  
							  ,"gradle"
							  ,"grails"
							  ,"Grizzly"
							  ,"gulp"
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
							  ,"java"
							  ,"javaee"
							  ,"javascript"
							  ,"javase"
							  ,"javassist"
							  
							  ,"javame"
							  ,"JDBC"
							  ,"jdi"
							  ,"jetbrain"
							  ,"jquery"
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
							  ,"unity"
							  ,"validate"
							  ,"velocity"
							  ,"verilog"
							  ,"viewerjs"
							  ,"VPS"
							  ,"wap"
							  ,"webbench"
							  ,"webpack"
							  ,"WebStorm"
							  ,"wiki"
							  ,"yum"
							  ,"zend"
							  ,"Zepto"
							  ,"ZeroMQ"
							  ,"Ztree"
							  };
		
		for(int i=0;i<searchbean.length;i++){
			mainnum = 0;
			traverseFolder("C:/简历file",searchbean[i]);
			System.out.println(searchbean[i]+": "+mainnum);
		}

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
    private static String getCharset(File file) throws IOException{  
        
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

}
