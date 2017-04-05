package com.mujuezhike.daily;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class HttpDaili {
	
	public static void main(String[] args) throws ClientProtocolException, IOException{
		
		HttpClient httpClient = new DefaultHttpClient();
        	
        HttpGet httpGet = new HttpGet("http://www.baidu.com/s?wd=" + "ABND".replace(" ", "%20"));
		//HttpGet httpGet = new HttpGet("http://216.58.200.46");
		
        HttpHost proxy = new HttpHost("46.218.50.156",3129,"http");
	    RequestConfig config = RequestConfig.custom().setProxy(proxy).setConnectTimeout(1000 * 60).build();
       
        httpGet.setConfig(config);
        
        HttpResponse httpResponse = httpClient.execute(httpGet);	
		
        if(httpResponse.getStatusLine().getStatusCode() == 200){
            //System.out.println("访问成功");
            HttpEntity httpEntity = httpResponse.getEntity();
            String response = EntityUtils.toString(httpEntity);
            //getFileFromBytes(response,"E:\\webspider\\u.html");
            System.out.println(response);
        }
		
	}

}
