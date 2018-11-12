package com.b2c.service.impl;

import com.b2c.common.pojo.EUDataGridResult;
import com.b2c.common.pojo.ResponseResult;
import com.b2c.common.utils.IDUtils;
import com.b2c.mapper.ItemDescMapper;
import com.b2c.mapper.ItemMapper;
import com.b2c.mapper.ItemParamItemMapper;
import com.b2c.pojo.Item;
import com.b2c.pojo.ItemDesc;
import com.b2c.pojo.ItemExample;
import com.b2c.pojo.ItemParamItem;
import com.b2c.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by chenjinge on 2016/6/29.
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemMapper itemMapper;
    @Autowired
    ItemParamItemMapper itemParamItemMapper;
    @Autowired
    ItemDescMapper itemDescMapper;

    @Override
    public Item getItemById(long itemId) {
        ItemExample itemExample = new ItemExample();
        itemExample.createCriteria().andIdEqualTo(itemId);
        List<Item> items = itemMapper.selectByExample(itemExample);
        if (!items.isEmpty()) {
            return items.get(0);
        }
        return null;
    }

    /**
     * 商品列表查询
     * <p>Title: getItemList</p>
     * <p>Description: </p>
     *
     * @param page
     * @param rows
     * @return
     * @see com.b2c.service.ItemService#getItemList(int, int)
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

    @Override
    public ResponseResult createItem(Item item, String desc, String itemParam) throws Exception {
        //item补全
        //生成商品ID
        Long itemId = IDUtils.genItemId();
        item.setId(itemId);
        // '商品状态，1-正常，2-下架，3-删除',
        item.setStatus((byte) 1);
        item.setCreated(new Date());
        item.setUpdated(new Date());
        //插入到数据库
        itemMapper.insert(item);
        //添加商品描述信息
        ResponseResult result = insertItemDesc(itemId, desc);
        if (result.getStatus() != 200) {
            throw new Exception();
        }
        //添加规格参数
        result = insertItemParamItem(itemId, itemParam);
        if (result.getStatus() != 200) {
            throw new Exception();
        }
        return ResponseResult.ok();
    }

    /**
     * 添加商品描述
     * <p>Title: insertItemDesc</p>
     * <p>Description: </p>
     *
     * @param desc
     */
    private ResponseResult insertItemDesc(Long itemId, String desc) {
        ItemDesc itemDesc = new ItemDesc();
        itemDesc.setItemId(itemId);
        itemDesc.setItemDesc(desc);
        itemDesc.setCreated(new Date());
        itemDesc.setUpdated(new Date());
        itemDescMapper.insert(itemDesc);
        return ResponseResult.ok();
    }

    /**
     * 添加规格参数
     * <p>Title: insertItemParamItem</p>
     * <p>Description: </p>
     *
     * @param itemId
     * @param itemParam
     * @return
     */
    private ResponseResult insertItemParamItem(Long itemId, String itemParam) {
        //创建一个pojo
        ItemParamItem itemParamItem = new ItemParamItem();
        itemParamItem.setItemId(itemId);
        itemParamItem.setParamData(itemParam);
        itemParamItem.setCreated(new Date());
        itemParamItem.setUpdated(new Date());
        //向表中插入数据
        itemParamItemMapper.insert(itemParamItem);

        return ResponseResult.ok();

    }
}
