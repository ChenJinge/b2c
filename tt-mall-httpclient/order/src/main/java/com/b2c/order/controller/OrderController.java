package com.b2c.order.controller;

import com.b2c.common.pojo.ResponseResult;
import com.b2c.common.utils.ExceptionUtil;
import com.b2c.order.pojo.ExOrder;
import com.b2c.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	@ResponseBody
	public ResponseResult createOrder(@RequestBody ExOrder order) {
		try {
			ResponseResult result = orderService.createOrder(order, order.getOrderItems(), order.getOrderShipping());
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
}
