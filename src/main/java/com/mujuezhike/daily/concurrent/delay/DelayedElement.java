package com.mujuezhike.daily.concurrent.delay;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedElement implements Delayed {

	private String id;
	
	private String name;
	
	@Override
	public int compareTo(Delayed o) {
		return this.hashCode() - o.hashCode();
	}

	@Override
	public long getDelay(TimeUnit unit) {
		System.out.println("getDelay:  "+unit);
		return 1000000;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
