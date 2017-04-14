package com.mujuezhike.daily.concurrent.linkedblockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueTest {

	public static void main(String[] args) {
		
		BlockingQueue<String> unbounded = new LinkedBlockingQueue<String>();  
		BlockingQueue<String> bounded   = new LinkedBlockingQueue<String>(1024);  
		  
		try {
			
			
			String value = bounded.take(); 
			System.out.println(value);
			System.out.println(bounded.size());
			value = bounded.take();
			System.out.println(value);
			System.out.println(bounded.size());
			value = bounded.take();
			System.out.println(value);
			System.out.println(bounded.size());
			value = bounded.take();
			System.out.println(value);
			System.out.println(bounded.size());
			bounded.put("1");
			bounded.put("2");
			bounded.put("3");
			bounded.put("4");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		  
		

	}

}
