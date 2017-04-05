package com.mujuezhike.daily;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.mujuezhike.daily.webspider.SearchResult;

@SuppressWarnings("deprecation")
public class WebSpider {

	static String s = "";
	static SearchResult r = new SearchResult();
	static Map<String, SearchResult> map = new HashMap<String,SearchResult>();
	static List<String> lastrlist = new ArrayList<String>();
	private static HttpClient httpClient;
	
	public static void main(String[] args) {
		
		s = "战舰少女R";
		
		while(true){
			try {
				Thread.sleep(1000l);
				SearchResult r = searchWords(s);
				map.put(s, r);
				
				if(r.getRelateBean()!=null && r.getRelateBean().size()>0){
					
					
					String m = "";
					for(String u:r.getRelateBean()){
						
						SearchResult rr = map.get(u);
						
						if(u.length()<=10 && null == rr){
							
							m = u;
							break;
						}
						
					}
					
					if(m.equals("")){
						
							
						for(String u:lastrlist){
								
								SearchResult rr = map.get(u);
								
								if(u.length()<=4 && null == rr){
									
									m = u;
									break;
								}
								
						}
						
						if(m.equals("")){
							return;
						}else{
							s = m;
						}
						
						
					}else{
						
						lastrlist = map.get(s).getRelateBean();
						s = m;
						
					}
				}
				
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	 /**  
	  * 将String数据存为文件  
	  */  
	 public static File getFileFromBytes(String str,String path) {  
	     
		 byte[] b=str.getBytes();  
	     
	     BufferedOutputStream stream = null;  
	     File file = null;  
	     try {  
	         file = new File(path);  
	         FileOutputStream fstream = new FileOutputStream(file);  
	         stream = new BufferedOutputStream(fstream);  
	         stream.write(b);  
	     } catch (Exception e) {  
	         e.printStackTrace();  
	     } finally {  
	         if (stream != null) {  
	             try {  
	                 stream.close();  
	             } catch (IOException e1) {  
	                 e1.printStackTrace();  
	             }  
	         }  
	     }  
	     return file;  
	     
	 } 
	 
	 /**  
	  * 将String数据存为文件  
	  */  
	 public static SearchResult searchWords(String searchBean) {
		
		    SearchResult r = new SearchResult();
		 
	        httpClient = new DefaultHttpClient();
	        //HttpGet httpGet = new HttpGet("http://www.baidu.com/s?wd=" + searchBean);
	        try {
	        	
	        	HttpGet httpGet = new HttpGet("http://www.baidu.com/s?wd=" + searchBean.replace(" ", "%20"));
	            HttpResponse httpResponse = httpClient.execute(httpGet);
	            if(httpResponse.getStatusLine().getStatusCode() == 200){
	                //System.out.println("访问成功");
	                HttpEntity httpEntity = httpResponse.getEntity();
	                String response = EntityUtils.toString(httpEntity);
	                //getFileFromBytes(response,"E:\\webspider\\u.html");
	                //System.out.println(response);
	                
	                Pattern pattern = Pattern.compile("百度为您找到相关结果约(.+?)个");   
	        		Matcher matcher = pattern.matcher(response);   
	                
	        		if(matcher.find()){
	        			
	        			System.out.println(searchBean);
		                System.out.println(matcher.group(1));
		                String num = matcher.group(1).replaceAll(",", "");
		                BigInteger b = new BigInteger(num);
		                r.setCount(b);
		                
	        		}
	        		
	        		Pattern patternRelate = Pattern.compile("<div class=\"tt\">相关搜索</div><table cellpadding=\"0\">(.+?)</table>");   
	        		Matcher matcherRelate = patternRelate.matcher(response);   
	                
	        		if(matcherRelate.find()){
	        			
	        			List<String> rlist = new ArrayList<String>();
	        			
		                String dom =  matcherRelate.group(1);
		                Document doc = Jsoup.parse(dom);
		        		Elements es = doc.getElementsByTag("a");
		        		
		        		//System.out.println("相关搜索");
		        		for(int i=0;i<es.size();i++){
		        			rlist.add(es.get(i).html());
		        			System.out.print(es.get(i).html()+" | ");
		        		}     
		        		System.out.println("");
		        		
		        		r.setRelateBean(rlist);
	        		}
	        		
	        		return r;
	            }
	        } catch (ClientProtocolException e) {
	            
	        	e.printStackTrace();
	        } catch (IOException e) {
	            
	        	e.printStackTrace();
	        } catch (IllegalArgumentException e) {
	            
	        	e.printStackTrace();
	        }
	        
			return null;
		 
	 }

}
