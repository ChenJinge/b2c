package com.b2c.controller;

import com.b2c.pojo.Item;
import com.b2c.pojo.ItemExample;
import com.b2c.service.ItemService;
import com.b2c.common.pojo.EUDataGridResult;
import com.b2c.common.pojo.ResponseResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    /**
     * 商品列表查询
     * <p>Title: getItemList</p>
     * <p>Description: </p>
     * @param page
     * @param rows
     * @return
     * @see com.b2c.service.ItemService#getItemList(long, long)
     */
    @Override
    public EUDataGridResult getItemList(int page, int rows) {
        //查询商品列表
        ItemExample example = new ItemExample();
        //分页处理
        PageHelper.startPage(page, rows);
        List<Item> list = itemMapper.selectByExample(example);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<Item> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
}
