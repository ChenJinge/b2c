package com.b2c.search.service;

import com.b2c.search.pojo.SearchResult;

public interface SearchService {

	SearchResult search(String queryString, int page, int rows) throws Exception;
}
