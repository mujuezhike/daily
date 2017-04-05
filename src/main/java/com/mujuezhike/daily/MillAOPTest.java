package com.mujuezhike.daily;

import com.mchange.v2.reflect.ReflectUtils;
import com.mujuezhike.daily.test.entity.SearchBean;

public class MillAOPTest {
	
	public static void main(String[] args){
		
		SearchBean s = new SearchBean();
		s.setId(11l);
		s.setName("SearchBean");
		s.setCount(66l);
		s.setStatus(0);
		
		Class[] cs = ReflectUtils.PROXY_CTOR_ARGS;
		
		System.out.println(cs[0].getName());
		
	}

}
