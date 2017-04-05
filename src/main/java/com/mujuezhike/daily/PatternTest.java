package com.mujuezhike.daily;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {
	
	public static void main(String[] args){
		
		
		Pattern pattern = Pattern.compile("百度为您找到相关结果约(.+?)个");   
		Matcher matcher = pattern.matcher("324324234百度为您找到相关结果约18,500,000个423423423432");   
        
		if(matcher.find())   
          System.out.println(matcher.group(1));   
		
		
		
	}
	
}
 