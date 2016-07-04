package com.b2c.controller;

import com.b2c.common.pojo.EUDataGridResult;
import com.b2c.common.pojo.ResponseResult;
import com.b2c.pojo.Item;
import com.b2c.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/item/{itemId}")
    @ResponseBody
    public Item getItemById(@PathVariable Long itemId) {
        Item item = itemService.getItemById(itemId);
        return item;
    }

    @RequestMapping("/item/list")
    @ResponseBody
    public EUDataGridResult getItemList(Integer pageNum, Integer pageSize) {
        EUDataGridResult result = itemService.getItemList(pageNum, pageSize);
        return result;
    }

    @RequestMapping(value="/item/save", method= RequestMethod.POST)
    @ResponseBody
    private ResponseResult createItem(Item item, String desc, String itemParams) throws Exception {
        ResponseResult result = itemService.createItem(item, desc, itemParams);
        return result;
    }
}
