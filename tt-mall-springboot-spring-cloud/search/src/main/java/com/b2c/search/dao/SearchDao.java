package com.b2c.search.dao;

import org.apache.solr.client.solrj.SolrQuery;

import com.b2c.search.pojo.SearchResult;

public interface SearchDao {

	SearchResult search(SolrQuery query) throws Exception;
}
