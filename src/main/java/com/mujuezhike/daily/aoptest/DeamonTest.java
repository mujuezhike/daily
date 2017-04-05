package com.mujuezhike.daily.aoptest;

public class DeamonTest {
	
	 public static void main(String[] args) throws InterruptedException  

	    {  

	        Runnable tr=new TestRunnable();  

	        Thread thread=new Thread(tr);  

	                thread.setDaemon(true); //设置守护线程  

	        thread.start(); //开始执行分进程  

	    }  

}
