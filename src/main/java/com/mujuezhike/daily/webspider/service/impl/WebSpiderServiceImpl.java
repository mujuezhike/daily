package com.mujuezhike.daily.webspider.service.impl;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mujuezhike.daily.test.dao.RelatedBeanDao;
import com.mujuezhike.daily.test.dao.SearchBeanDao;
import com.mujuezhike.daily.test.entity.RelatedBean;
import com.mujuezhike.daily.test.entity.SearchBean;
import com.mujuezhike.daily.test.enums.StatusEnum;
import com.mujuezhike.daily.webspider.SearchResult;
import com.mujuezhike.daily.webspider.service.WebSpiderService;

@Component
public class WebSpiderServiceImpl  implements WebSpiderService{

	@Autowired
	private SearchBeanDao searchBeanDao;
	
	@Autowired
	private RelatedBeanDao relatedBeanDao;
	
	@Override
	public SearchResult searchWords(String searchBean) {
		
		String s = "";
		SearchResult r = new SearchResult();
		Map<String, SearchResult> map = new HashMap<String,SearchResult>();
		List<String> lastrlist = new ArrayList<String>();
		HttpClient httpClient;
		
		//SearchResult r = new SearchResult();
		r.setName(searchBean);
        httpClient = new DefaultHttpClient();
        //HttpGet httpGet = new HttpGet("http://www.baidu.com/s?wd=" + searchBean);
        try {
        	
        	HttpGet httpGet = new HttpGet("http://www.baidu.com/s?wd=" + searchBean.replace(" ", "%20"));
            
        	/** 代理    **/
        	HttpHost proxy = new HttpHost("61.172.51.68",38931,"http");
    	    RequestConfig config = RequestConfig.custom().setProxy(proxy).setConnectTimeout(1000 * 60).build();
           
            httpGet.setConfig(config);
            /** 代理    end **/
            
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

	@Override
	public SearchBean saveSearchResult(SearchResult searchResult) {
		
		SearchBean sb = new SearchBean();
		sb.setName(searchResult.getName());
		sb.setCount(searchResult.getCount().longValue());
		sb.setStatus(StatusEnum.NORMAL.ordinal());
		
		searchBeanDao.insert(sb);
		
		List<String> rlist = searchResult.getRelateBean();
		
		if(rlist!=null){
			for(int i = 0;i<rlist.size();i++){
				RelatedBean rb = new RelatedBean();
				rb.setMainId(sb.getId());
				rb.setMainName(sb.getName());
				rb.setRelatedName(rlist.get(i));
				
				relatedBeanDao.insert(rb);
			}
		}
		
		return sb;
	}

	@Override
	public void generateSearchBean(String source) {
		
		List<String> lastrlist = new ArrayList<String>();
		
		while(true){
			try {
				Thread.sleep(1005l);
				SearchResult r = searchWords(source);
				
				SearchBean dssb = new SearchBean();
				dssb.setName(source);
				
				List<SearchBean> dlist = searchBeanDao.selectBySearchBean(dssb);
				
				if(dlist==null || dlist.size()==0){
					saveSearchResult(r);
				}else{
					return;
				}
				
				if(r.getRelateBean()!=null && r.getRelateBean().size()>0){
					
					String m = "";
					for(String u:r.getRelateBean()){
						
						SearchBean ssb = new SearchBean();
						ssb.setName(u);
						
						List<SearchBean> list = searchBeanDao.selectBySearchBean(ssb);
						
						//u.getBytes().length == u.length() 判断没有中文
						if(u.length()<=10 && (list==null||list.size()==0)
								&& u.getBytes().length == u.length()){
							
							m = u;
							break;
						}
						
					}
					
					if(m.equals("")){
						
							
						for(String u:lastrlist){
								
								SearchBean ssb = new SearchBean();
								ssb.setName(u);
							
								List<SearchBean> list = searchBeanDao.selectBySearchBean(ssb);
							
								//u.getBytes().length == u.length() 判断没有中文
								if(u.length()<=10 && (list==null||list.size()==0)
										&& u.getBytes().length == u.length()){
								
									m = u;
									break;
								}
								
						}
						
						if(m.equals("")){
							return;
						}else{
							source = m;
						}
						
						
					}else{
						
						lastrlist = r.getRelateBean();
						source = m;
						
					}
				}
				
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
