package com.mujuezhike.daily.concurrent.arrayblockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQueueTest {

	public static void main(String[] args) throws InterruptedException {
		
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1024);  
		  
		queue.put("1");
		queue.put("2");
		  
		String string = queue.take();  
		
		System.out.println(queue.element());
		System.out.println(string);
		
	}

}
