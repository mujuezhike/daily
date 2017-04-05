package com.mujuezhike.daily.aoptest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AOPTest {
	
	public static void main(String[] args){
		
		AOPTest at = new AOPTest();
		
		at.mmen();
	}
	
	public void todo(){
		System.out.println("c");
	}
	
	public void mmen(){
		
		//执行特定方法
//		try {
//			Method m = this.getClass().getMethod("stodo");
//			Class<?>[] mts = m.getParameterTypes();
//			m.invoke(this, null);
//		} catch (NoSuchMethodException | SecurityException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		} catch (IllegalArgumentException e) {
//			e.printStackTrace();
//		} catch (InvocationTargetException e) {
//			e.printStackTrace();
//		}
		
		Class thisclass = this.getClass();
		
		System.out.println("getName: 			" + thisclass.getName());
		System.out.println("isInterface: 		" + thisclass.isInterface());
		System.out.println("getCanonicalName:	" + thisclass.getCanonicalName());
		System.out.println("getClassLoader:		" + thisclass.getClassLoader());
		System.out.println("getModifiers:		" + thisclass.getModifiers());
		System.out.println("getPackage:			" + thisclass.getPackage());
		
	}

}
