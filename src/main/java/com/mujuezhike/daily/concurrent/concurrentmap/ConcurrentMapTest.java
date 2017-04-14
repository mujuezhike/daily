package com.mujuezhike.daily.concurrent.concurrentmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentMapTest {

	public static void main(String[] args) {
		
		final ConcurrentMap concurrentMap = new ConcurrentHashMap(); //50099625733 
		//final Map concurrentMap = new HashMap();                       //9466356407  
		final long n1 = System.nanoTime();
		
		Thread s3 = new Thread(new Runnable(){

			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Random rd = new Random();
					int s = rd.nextInt(10000);
					System.out.println(s + ":" + concurrentMap.get(s) + ":" + concurrentMap.size());
					 
				}
			}
			
		});
		
		Thread s2 = new Thread(new Runnable(){

			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Random rd = new Random();
					int s = rd.nextInt(10000);
					int c = rd.nextInt(10000);
					concurrentMap.put(s,c);
				}
			}
			
		});
		
		Thread s1 = new Thread(new Runnable(){

			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Random rd = new Random();
					int s = rd.nextInt(10000);
					int c = rd.nextInt(10000);
					concurrentMap.put(s,c);
				}
			}
			
		});
		
		s1.start();
		s2.start();
		s3.start();
		
		
	}

}
