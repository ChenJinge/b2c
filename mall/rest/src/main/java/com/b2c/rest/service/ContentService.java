package com.b2c.rest.service;

import com.b2c.pojo.Content;

import java.util.List;

public interface ContentService {

	List<Content> getContentList(long contentCid);
}
