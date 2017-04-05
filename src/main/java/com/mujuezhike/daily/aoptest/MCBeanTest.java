package com.mujuezhike.daily.aoptest;

public class MCBeanTest {
	
	public static void main(String[] args){
		
		MCBeanA a = new MCBeanA();
		a.setId(1l);
		a.setName("A");
		a.setContent("beana");
		
		MCBeanB b = new MCBeanB();
		b.setId(2l);
		b.setName("B");
		b.setContent("beanb");
		
		MCBeanC c = new MCBeanC();
		c.setId(3l);
		c.setName("C");
		c.setContent("beanc");
		
		b.setC(c);
		a.setB(b);
		
		a.viewBean();
		
	}

}
