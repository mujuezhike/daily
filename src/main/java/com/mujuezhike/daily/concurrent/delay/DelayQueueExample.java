package com.mujuezhike.daily.concurrent.delay;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueExample {

	public static void main(String[] args) {
		
		DelayQueue queue = new DelayQueue();  
		  
        Delayed element1 = new DelayedElement();  
        
        //element1.getDelay(TimeUnit.SECONDS);
  
        queue.put(element1);  
        queue.put(element1);  
        queue.put(element1);  
  
        try {
        	
			Delayed element2 = queue.take();
			System.out.println(element2);
			
			Delayed element3 = queue.take();
			System.out.println(element3);
			
			Delayed element4 = queue.take();
			System.out.println(element4);
		
        } catch (InterruptedException e) {
			
        	e.printStackTrace();
        	
		}  
		

	}

}
