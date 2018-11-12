package com.b2c.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.b2c.common.pojo.ResponseResult;
import com.b2c.pojo.Content;
import com.b2c.service.ContentService;

@Controller
@RequestMapping("/content")
public class ContentController {

	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/save")
	@ResponseBody
	public ResponseResult insertContent( Content content) {
		ResponseResult result = contentService.insertContent(content);
		return result;
	}
}
