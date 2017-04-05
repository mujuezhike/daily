package com.mujuezhike.daily.aoptest;

import org.omg.SendingContext.RunTime;

public class MCBeanC {

	private Long id;
	
	private String name;
	
	private String content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		
		Thread t = Thread.currentThread();
		
		StackTraceElement[] eles = t.getStackTrace();
		
		for(StackTraceElement ste:eles){
			
			System.out.println(ste.getClassName() + " | " + ste.getMethodName() + " | " + ste.getLineNumber());
			
		}
		
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
