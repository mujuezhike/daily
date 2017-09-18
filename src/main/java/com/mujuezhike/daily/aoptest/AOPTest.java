package com.mujuezhike.daily.aoptest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AOPTest {
	
	public String prt = "ABDMS";
	
	public static void main(String[] args) throws Exception{
//		
		AOPTest at = new AOPTest();
		
		at.mmen();
//		String s1 = RefPrint();
//		System.out.println(s1);
//		String s2 = NewPrint();
//		System.out.println(s2);
		
	}
	
	public static void todo(){
		
		System.out.println("ddder");
		
	}
	
	public void mmen() throws InstantiationException{
		
		//执行特定方法
		try {
			Class cs = this.getClass();
			Object ok = cs.newInstance();
			Method mm = ok.getClass().getMethod("todo");
			mm.invoke(this,null);
			Method m = this.getClass().getMethod("todo");
			Class<?>[] mts = m.getParameterTypes();
			m.invoke(null,null);
			
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		Class<? extends AOPTest> thisclass = this.getClass();
		
		System.out.println("getName: 			" + thisclass.getName());
		System.out.println("isInterface: 		" + thisclass.isInterface());
		System.out.println("getCanonicalName:	" + thisclass.getCanonicalName());
		System.out.println("getClassLoader:		" + thisclass.getClassLoader());
		System.out.println("getModifiers:		" + thisclass.getModifiers());
		System.out.println("getPackage:			" + thisclass.getPackage());
		
	}
	
	//一千次反射类 调用方法  统计时间
	public static String RefPrint() throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		
		long s1 = System.currentTimeMillis();
		
		for(int i=0;i<100000000;i++){
			Class cs = AOPTest.class;
			Object ok = cs.newInstance();
			Method mm = ok.getClass().getMethod("todo");
			mm.invoke(ok,null);
		}
		
		long s2 = System.currentTimeMillis();
		
		return "使用时间"+(s2-s1);
	}
	
	//一千次新建类 调用方法  统计时间
	public static String NewPrint(){
		
		long s1 = System.currentTimeMillis();
		
		for(int i=0;i<100000000;i++){
			AOPTest s = new AOPTest();
			s.todo();
		}
		
		long s2 = System.currentTimeMillis();
		
		return "使用时间"+(s2-s1);
		
	}

}
