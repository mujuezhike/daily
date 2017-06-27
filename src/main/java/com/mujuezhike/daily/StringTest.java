package com.mujuezhike.daily;

public class StringTest {

	public static void main(String[] args) {
		
		String s = "51job_陈维杰(217180291)_files";
		if(s.contains("51job_")){
			s = s.substring(5);
		};
		if(s.contains("(")){
			s = s.substring(0, s.indexOf("("));
		}
		
		System.out.println(s);
	}

}
