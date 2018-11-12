package com.b2c.rest.service;

import com.b2c.common.pojo.ResponseResult;

public interface ItemService {

	ResponseResult getItemBaseInfo(long itemId);
	ResponseResult getItemDesc(long itemId);
	ResponseResult getItemParam(long itemId);
}
