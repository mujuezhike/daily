package com.mujuezhike.daily.concurrent.arrayblockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {

	public static void main(String[] args) {
		
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1024);  
		  
	    Producer producer = new Producer(queue);  
	    Consumer consumer = new Consumer(queue);  
	  
	    new Thread(producer).start();  
	    new Thread(consumer).start();  
	  
	    try {
			
	    	Thread.sleep(4000);
	    	
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			
		} 
		
	}

}
