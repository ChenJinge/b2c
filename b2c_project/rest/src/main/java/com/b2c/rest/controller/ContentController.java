package com.b2c.rest.controller;

import com.b2c.common.pojo.ResponseResult;
import com.b2c.common.utils.ExceptionUtil;
import com.b2c.pojo.Content;
import com.b2c.rest.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @RequestMapping("/list/{contentCategoryId}")
    @ResponseBody
    public ResponseResult getContentList(@PathVariable Long contentCategoryId) {
        try {
            List<Content> list = contentService.getContentList(contentCategoryId);
            return ResponseResult.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseResult.build(500, ExceptionUtil.getStackTrace(e));
        }
    }
}