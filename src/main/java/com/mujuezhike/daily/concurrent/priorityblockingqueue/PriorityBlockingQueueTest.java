package com.mujuezhike.daily.concurrent.priorityblockingqueue;

import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueTest {

	public static void main(String[] args) {
		
		PriorityBlockingQueue<PriBean> pbq = new PriorityBlockingQueue<PriBean>();
		
		PriBean p1 = new PriBean();
		p1.setId(2l);
		pbq.put(p1);
		
		PriBean p2 = new PriBean();
		p2.setId(1l);
		pbq.put(p2);
		
		PriBean p3 = new PriBean();
		p3.setId(2l);
		pbq.put(p3);
		
		PriBean p4 = new PriBean();
		p4.setId(3l);
		pbq.put(p4);
		
		PriBean p5 = new PriBean();
		p5.setId(2l);
		pbq.put(p5);
		
		try {
			System.out.println(pbq.take());
			System.out.println(pbq.take());
			System.out.println(pbq.take());
			System.out.println(pbq.take());
			System.out.println(pbq.take());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
