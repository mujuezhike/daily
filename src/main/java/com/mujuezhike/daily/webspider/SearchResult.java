package com.mujuezhike.daily.webspider;

import java.math.BigInteger;
import java.util.List;

public class SearchResult {
	
	private String name;
	
	private BigInteger count;
	
	private List<String> relateBean;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigInteger getCount() {
		return count;
	}

	public void setCount(BigInteger count) {
		this.count = count;
	}

	public List<String> getRelateBean() {
		return relateBean;
	}

	public void setRelateBean(List<String> relateBean) {
		this.relateBean = relateBean;
	}
	
}
