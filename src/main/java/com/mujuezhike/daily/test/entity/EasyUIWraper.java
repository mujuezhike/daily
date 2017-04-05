package com.mujuezhike.daily.test.entity;

import java.util.List;

public class EasyUIWraper<T> {

	private int total;
	private List<T> rows;
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}

}
