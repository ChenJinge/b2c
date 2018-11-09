package com.b2c.service;

import com.b2c.common.pojo.EUTreeNode;
import com.b2c.common.pojo.ResponseResult;

import java.util.List;

/**
 * Created by chenjinge on 2016/7/4.
 */
public interface ContentCategoryService {

    List<EUTreeNode> getCategoryList(long parentId);
    ResponseResult insertContentCategory(long parentId, String name);
}
