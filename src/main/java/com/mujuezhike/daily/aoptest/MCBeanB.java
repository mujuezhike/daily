package com.mujuezhike.daily.aoptest;

public class MCBeanB {
	
	private Long id;
	
	private String name;
	
	private String content;
	
	private MCBeanC c;

	public MCBeanC getC() {
		return c;
	}

	public void setC(MCBeanC c) {
		this.c = c;
	}

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
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public void viewBean(){
		
		this.setContent(c.getContent());
		
	}
	
}
