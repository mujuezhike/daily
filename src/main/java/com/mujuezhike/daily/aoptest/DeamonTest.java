package com.mujuezhike.daily.aoptest;

/**
 * 守护线程测试
 * @author mujuezhike
 */
public class DeamonTest {
	
	 public static void main(String[] args) throws InterruptedException  

	    {  

	        Runnable tr=new TestRunnable();  

	        Thread thread=new Thread(tr);  

	                thread.setDaemon(true); //设置守护线程  

	        thread.start(); //开始执行分进程  

	    }  

}
