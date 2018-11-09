package com.b2c.service;

import com.b2c.common.pojo.EUTreeNode;

import java.util.List;

/**
 * Created by chenjinge on 2016/7/4.
 */
public interface ItemCatService {

    List<EUTreeNode> getCatList(long parentId);
}
