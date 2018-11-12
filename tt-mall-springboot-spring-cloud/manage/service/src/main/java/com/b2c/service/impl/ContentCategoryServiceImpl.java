package com.b2c.service.impl;

import com.b2c.common.pojo.EUTreeNode;
import com.b2c.common.pojo.ResponseResult;
import com.b2c.mapper.ContentCategoryMapper;
import com.b2c.pojo.ContentCategory;
import com.b2c.pojo.ContentCategoryExample;
import com.b2c.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by chenjinge on 2016/7/4.
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

    @Autowired
    private ContentCategoryMapper contentCategoryMapper;
    @Override
    public List<EUTreeNode> getCategoryList(long parentId) {
        //根据parentid查询节点列表
        ContentCategoryExample example = new ContentCategoryExample();
        ContentCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        //执行查询
        List<ContentCategory> list = contentCategoryMapper.selectByExample(example);
        List<EUTreeNode> resultList = new ArrayList<>();
        for (ContentCategory tbContentCategory : list) {
            //创建一个节点
            EUTreeNode node = new EUTreeNode();
            node.setId(tbContentCategory.getId());
            node.setText(tbContentCategory.getName());
            node.setState(tbContentCategory.getIsParent()?"closed":"open");

            resultList.add(node);
        }
        return resultList;
    }
    @Override
    public ResponseResult insertContentCategory(long parentId, String name) {

        //创建一个pojo
        ContentCategory contentCategory = new ContentCategory();
        contentCategory.setName(name);
        contentCategory.setIsParent(false);
        //'状态。可选值:1(正常),2(删除)',
        contentCategory.setStatus(1);
        contentCategory.setParentId(parentId);
        contentCategory.setSortOrder(1);
        contentCategory.setCreated(new Date());
        contentCategory.setUpdated(new Date());
        //添加记录
        contentCategoryMapper.insert(contentCategory);
        //查看父节点的isParent列是否为true，如果不是true改成true
        ContentCategory parentCat = contentCategoryMapper.selectByPrimaryKey(parentId);
        //判断是否为true
        if(!parentCat.getIsParent()) {
            parentCat.setIsParent(true);
            //更新父节点
            contentCategoryMapper.updateByPrimaryKey(parentCat);
        }
        //返回结果
        return ResponseResult.ok(contentCategory);
    }

}
