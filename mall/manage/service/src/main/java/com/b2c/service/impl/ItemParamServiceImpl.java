package com.b2c.service.impl;

import com.b2c.common.pojo.ResponseResult;
import com.b2c.mapper.ItemParamMapper;
import com.b2c.pojo.ItemParam;
import com.b2c.pojo.ItemParamExample;
import com.b2c.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by chenjinge on 2016/7/4.
 */
@Service
public class ItemParamServiceImpl implements ItemParamService {

    @Autowired
    private ItemParamMapper itemParamMapper;

    @Override
    public ResponseResult getItemParamByCid(long cid) {
        ItemParamExample example = new ItemParamExample();
        ItemParamExample.Criteria criteria = example.createCriteria();
        criteria.andItemCatIdEqualTo(cid);
        List<ItemParam> list = itemParamMapper.selectByExampleWithBLOBs(example);
        //判断是否查询到结果
        if (list != null && list.size() > 0) {
            return ResponseResult.ok(list.get(0));
        }

        return ResponseResult.ok();
    }

    @Override
    public ResponseResult insertItemParam(ItemParam itemParam) {
        //补全pojo
        itemParam.setCreated(new Date());
        itemParam.setUpdated(new Date());
        //插入到规格参数模板表
        itemParamMapper.insert(itemParam);
        return ResponseResult.ok();
    }

}
