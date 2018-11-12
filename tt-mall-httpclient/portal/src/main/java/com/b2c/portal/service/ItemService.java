package com.b2c.portal.service;

import com.b2c.portal.pojo.ItemInfo;

public interface ItemService {

    ItemInfo getItemById(Long itemId);

    String getItemDescById(Long itemId);

    String getItemParam(Long itemId);

}
