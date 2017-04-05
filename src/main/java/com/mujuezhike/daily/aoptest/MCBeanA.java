package com.mujuezhike.daily.aoptest;

public class MCBeanA {
	
	private Long id;
	
	private String name;
	
	private String content;
	
	private MCBeanB b;

	public MCBeanB getB() {
		return b;
	}

	public void setB(MCBeanB b) {
		this.b = b;
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
		
		b.viewBean();
		this.setContent(b.getContent());
		
	}
	
}
