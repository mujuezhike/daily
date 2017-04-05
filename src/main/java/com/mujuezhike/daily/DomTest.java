package com.mujuezhike.daily;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class DomTest {

	public static void main(String[] args){
		
		String dom = "<th><a href=\"/s?wd=%E4%B8%87%E6%99%BA%E7%89%8C2016%E5%AE%89%E5%8D%93%E4%B8%AD%E6%96%87%E7%89%88&rsf=1&rsp=0&f=1&oq=%E4%B8%87%E6%99%BA%E7%89%8C&ie=utf-8&usm=2&rsv_pq=bae8453600009225&rsv_t=a90fHBJ5moL4iPZTbMDXzkooBMUdvujDk1G1zEUShjxc%2FPV5yrpTSHtn7D4&rqlang=cn&rs_src=0&rsv_pq=bae8453600009225&rsv_t=a90fHBJ5moL4iPZTbMDXzkooBMUdvujDk1G1zEUShjxc%2FPV5yrpTSHtn7D4\">万智牌2016安卓中文版</a></th><td></td><th><a href=\"/s?wd=%E6%98%86%E7%89%B9%E7%89%8C%E5%AE%98%E7%BD%91&rsf=1&rsp=1&f=1&oq=%E4%B8%87%E6%99%BA%E7%89%8C&ie=utf-8&usm=2&rsv_pq=bae8453600009225&rsv_t=a90fHBJ5moL4iPZTbMDXzkooBMUdvujDk1G1zEUShjxc%2FPV5yrpTSHtn7D4&rqlang=cn&rs_src=0&rsv_pq=bae8453600009225&rsv_t=a90fHBJ5moL4iPZTbMDXzkooBMUdvujDk1G1zEUShjxc%2FPV5yrpTSHtn7D4\">昆特牌官网</a></th><td></td><th><a href=\"/s?wd=%E4%B8%87%E6%99%BA%E7%89%8C%E5%AE%98%E7%BD%91&rsf=1&rsp=2&f=1&oq=%E4%B8%87%E6%99%BA%E7%89%8C&ie=utf-8&usm=2&rsv_pq=bae8453600009225&rsv_t=a90fHBJ5moL4iPZTbMDXzkooBMUdvujDk1G1zEUShjxc%2FPV5yrpTSHtn7D4&rqlang=cn&rs_src=0&rsv_pq=bae8453600009225&rsv_t=a90fHBJ5moL4iPZTbMDXzkooBMUdvujDk1G1zEUShjxc%2FPV5yrpTSHtn7D4\">万智牌官网</a></th></tr><tr><th><a href=\"/s?wd=%E4%B8%87%E6%99%BA%E7%89%8C%E7%89%8C%E5%BA%97&rsf=8&rsp=3&f=1&oq=%E4%B8%87%E6%99%BA%E7%89%8C&ie=utf-8&usm=2&rsv_pq=bae8453600009225&rsv_t=a90fHBJ5moL4iPZTbMDXzkooBMUdvujDk1G1zEUShjxc%2FPV5yrpTSHtn7D4&rqlang=cn&rs_src=1&rsv_pq=bae8453600009225&rsv_t=a90fHBJ5moL4iPZTbMDXzkooBMUdvujDk1G1zEUShjxc%2FPV5yrpTSHtn7D4\">万智牌牌店</a></th><td></td><th><a href=\"/s?wd=%E5%8D%A1%E7%89%8C%E7%B1%BB%E6%B8%B8%E6%88%8F&rsf=1&rsp=4&f=1&oq=%E4%B8%87%E6%99%BA%E7%89%8C&ie=utf-8&usm=2&rsv_pq=bae8453600009225&rsv_t=a90fHBJ5moL4iPZTbMDXzkooBMUdvujDk1G1zEUShjxc%2FPV5yrpTSHtn7D4&rqlang=cn&rs_src=0&rsv_pq=bae8453600009225&rsv_t=a90fHBJ5moL4iPZTbMDXzkooBMUdvujDk1G1zEUShjxc%2FPV5yrpTSHtn7D4\">卡牌类游戏</a></th><td></td><th><a href=\"/s?wd=%E4%B8%87%E6%99%BA%E7%89%8C%E5%8D%81%E5%A4%A7%E6%9C%80%E8%B4%B5%E5%8D%A1%E7%89%8C&rsf=1&rsp=5&f=1&oq=%E4%B8%87%E6%99%BA%E7%89%8C&ie=utf-8&usm=2&rsv_pq=bae8453600009225&rsv_t=a90fHBJ5moL4iPZTbMDXzkooBMUdvujDk1G1zEUShjxc%2FPV5yrpTSHtn7D4&rqlang=cn&rs_src=0&rsv_pq=bae8453600009225&rsv_t=a90fHBJ5moL4iPZTbMDXzkooBMUdvujDk1G1zEUShjxc%2FPV5yrpTSHtn7D4\">万智牌十大最贵卡牌</a></th></tr><tr><th><a href=\"/s?wd=%E4%B8%87%E6%99%BA%E7%89%8C%E5%AE%89%E5%8D%93%E4%B8%AD%E6%96%87%E7%89%88&rsf=1&rsp=6&f=1&oq=%E4%B8%87%E6%99%BA%E7%89%8C&ie=utf-8&usm=2&rsv_pq=bae8453600009225&rsv_t=a90fHBJ5moL4iPZTbMDXzkooBMUdvujDk1G1zEUShjxc%2FPV5yrpTSHtn7D4&rqlang=cn&rs_src=0&rsv_pq=bae8453600009225&rsv_t=a90fHBJ5moL4iPZTbMDXzkooBMUdvujDk1G1zEUShjxc%2FPV5yrpTSHtn7D4\">万智牌安卓中文版</a></th><td></td><th><a href=\"/s?wd=%E4%B8%87%E6%99%BA%E7%89%8C%E6%9C%80%E8%B4%B5%E7%9A%84%E5%8D%A1%E9%BB%91%E8%8E%B2%E8%8A%B1&rsf=1&rsp=7&f=1&oq=%E4%B8%87%E6%99%BA%E7%89%8C&ie=utf-8&usm=2&rsv_pq=bae8453600009225&rsv_t=a90fHBJ5moL4iPZTbMDXzkooBMUdvujDk1G1zEUShjxc%2FPV5yrpTSHtn7D4&rqlang=cn&rs_src=0&rsv_pq=bae8453600009225&rsv_t=a90fHBJ5moL4iPZTbMDXzkooBMUdvujDk1G1zEUShjxc%2FPV5yrpTSHtn7D4\">万智牌最贵的卡黑莲花</a></th><td></td><th><a href=\"/s?wd=%E6%98%86%E7%89%B9%E7%89%8C%E6%89%8B%E6%9C%BA%E7%89%88&rsf=1&rsp=8&f=1&oq=%E4%B8%87%E6%99%BA%E7%89%8C&ie=utf-8&usm=2&rsv_pq=bae8453600009225&rsv_t=a90fHBJ5moL4iPZTbMDXzkooBMUdvujDk1G1zEUShjxc%2FPV5yrpTSHtn7D4&rqlang=cn&rs_src=0&rsv_pq=bae8453600009225&rsv_t=a90fHBJ5moL4iPZTbMDXzkooBMUdvujDk1G1zEUShjxc%2FPV5yrpTSHtn7D4\">昆特牌手机版</a></th></tr>";
        
		Document doc = Jsoup.parse(dom);
		Elements es = doc.getElementsByTag("a");
		
		for(int i=0;i<es.size();i++){
			System.out.println(es.get(i).html());
		}
				
	}
	
}
