package com.b2c.service.impl;

import com.b2c.mapper.ItemMapper;
import com.b2c.pojo.Item;
import com.b2c.pojo.ItemExample;
import com.b2c.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chenjinge on 2016/6/29.
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemMapper itemMapper;

    @Override
    public Item getItemById(long itemId) {
        ItemExample itemExample=new ItemExample();
        itemExample.createCriteria().andIdEqualTo(itemId);
        List<Item> items=itemMapper.selectByExample(itemExample);
        if (!items.isEmpty()){
            return items.get(0);
        }
        return null;
    }
}
