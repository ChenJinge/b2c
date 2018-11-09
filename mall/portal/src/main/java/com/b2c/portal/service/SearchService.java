package com.b2c.portal.service;

import com.b2c.portal.pojo.SearchResult;

public interface SearchService {

    SearchResult search(String queryString, int page);
}
