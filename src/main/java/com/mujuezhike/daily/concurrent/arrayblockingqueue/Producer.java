package com.mujuezhike.daily.concurrent.arrayblockingqueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{  
	  
    protected BlockingQueue<String> queue = null;  
  
    public Producer(BlockingQueue<String> queue) {  
        this.queue = queue;  
    }  
  
    public void run() {  
        try {  
            queue.put("1");  
            Thread.sleep(3000);  
            queue.put("2");  
            Thread.sleep(1000);  
            queue.put("3");  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
    }  
} 