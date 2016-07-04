package com.b2c.service;

import com.b2c.common.pojo.EUDataGridResult;
import com.b2c.common.pojo.ResponseResult;
import com.b2c.pojo.Item;


public interface ItemService {

    Item getItemById(long itemId);
    ResponseResult createItem(Item item, String desc, String itemParam) throws Exception;
    EUDataGridResult getItemList(int pageNum, int pageSize);
}
