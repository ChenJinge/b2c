package com.b2c.service;

import com.b2c.common.pojo.ResponseResult;
import com.b2c.pojo.ItemParam;

/**
 * Created by chenjinge on 2016/7/4.
 */
public interface ItemParamService {

    ResponseResult getItemParamByCid(long cid);
    ResponseResult insertItemParam(ItemParam itemParam);
}
