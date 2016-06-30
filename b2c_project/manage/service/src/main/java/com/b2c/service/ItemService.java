package com.b2c.service;

import com.b2c.pojo.Item;

import java.util.List;


public interface ItemService {

	Item getItemById(long itemId);

    List<Item> getItemList(long pageNum, long pageSize);
}
