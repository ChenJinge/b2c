package com.b2c.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.b2c.common.pojo.ResponseResult;
import com.b2c.rest.service.RedisService;

/**
 * 缓存同步Controller
 * <p>Title: RedisController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 * @author	入云龙
 * @date	2015年9月9日下午3:47:18
 * @version 1.0
 */
@Controller
@RequestMapping("/cache/sync")
public class RedisController {

	@Autowired
	private RedisService redisService;
	
	@RequestMapping("/content/{contentCid}")
	@ResponseBody
	public ResponseResult contentCacheSync(@PathVariable Long contentCid) {
		ResponseResult result = redisService.syncContent(contentCid);
		return result;
	}
}
