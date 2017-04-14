package com.mujuezhike.daily.concurrent.linkedblockingdeque;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class LinkedBlockingDequeTest {

	public static void main(String[] args) {
		
		BlockingDeque<String> deque = new LinkedBlockingDeque<String>();  
		  
		deque.addFirst("1"); 
		deque.addFirst("2"); 
		deque.addFirst("3"); 
		deque.addFirst("4"); 
		deque.addLast("21");
		deque.addLast("22");
		deque.addLast("23");
		deque.addLast("24");
		  
		try {
			
			System.out.println(deque.takeFirst());
			System.out.println(deque.takeFirst());
			System.out.println(deque.takeLast());
			System.out.println(deque.takeLast());
			System.out.println(deque.takeLast());
			System.out.println(deque.takeLast());
			System.out.println(deque.takeLast());
			System.out.println(deque.takeLast());
			
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			
		}  
		 
		
	}

}
