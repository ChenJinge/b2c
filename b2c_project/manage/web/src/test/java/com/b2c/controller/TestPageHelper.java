package com.b2c.controller;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.b2c.mapper.ItemMapper;
import com.b2c.pojo.Item;
import com.b2c.pojo.ItemExample;

public class TestPageHelper {

	@Test
	public void testPageHelper() {
		//创建一个spring容器
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		//从spring容器中获得Mapper的代理对象
		ItemMapper mapper = applicationContext.getBean(ItemMapper.class);
		//执行查询，并分页
		ItemExample example = new ItemExample();
		//分页处理
		PageHelper.startPage(2, 10);
		List<Item> list = mapper.selectByExample(example);
		//取商品列表
		for (Item tbItem : list) {
			System.out.println(tbItem.getTitle());
		}
		//取分页信息
		PageInfo<Item> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		System.out.println("共有商品："+ total);
		
	}
}