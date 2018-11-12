package com.b2c.service.impl;

import com.b2c.common.pojo.EUTreeNode;
import com.b2c.mapper.ItemCatMapper;
import com.b2c.pojo.ItemCat;
import com.b2c.pojo.ItemCatExample;
import com.b2c.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenjinge on 2016/7/4.
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private ItemCatMapper itemCatMapper;
    @Override
    public List<EUTreeNode> getCatList(long parentId) {

        //创建查询条件
        ItemCatExample example = new ItemCatExample();
        ItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        //根据条件查询
        List<ItemCat> list = itemCatMapper.selectByExample(example);
        List<EUTreeNode> resultList = new ArrayList<>();
        //把列表转换成treeNodelist
        for (ItemCat ItemCat : list) {
            EUTreeNode node = new EUTreeNode();
            node.setId(ItemCat.getId());
            node.setText(ItemCat.getName());
            node.setState(ItemCat.getIsParent()?"closed":"open");
            resultList.add(node);
        }
        //返回结果
        return resultList;
    }

}
