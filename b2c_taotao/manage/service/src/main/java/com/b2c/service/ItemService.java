package com.b2c.service;

import com.b2c.common.pojo.EUDataGridResult;
import com.b2c.common.pojo.TaotaoResult;
import com.b2c.pojo.TbItem;

public interface ItemService {

	TbItem getItemById(long itemId);
	EUDataGridResult getItemList(int page, int rows);
	TaotaoResult createItem(TbItem item, String desc, String itemParam) throws Exception;
}
