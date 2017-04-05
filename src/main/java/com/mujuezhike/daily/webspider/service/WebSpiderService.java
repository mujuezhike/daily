package com.mujuezhike.daily.webspider.service;

import com.mujuezhike.daily.test.entity.SearchBean;
import com.mujuezhike.daily.webspider.SearchResult;

public interface WebSpiderService {

	public SearchResult searchWords(String searchStr);
	
	public SearchBean saveSearchResult(SearchResult searchResult);
	
	public void generateSearchBean(String source);
	
}
