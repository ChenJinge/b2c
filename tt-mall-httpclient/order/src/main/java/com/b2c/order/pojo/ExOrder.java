package com.b2c.order.pojo;

import java.util.List;

import com.b2c.pojo.Order;
import com.b2c.pojo.OrderItem;
import com.b2c.pojo.OrderShipping;

public class ExOrder extends Order {

	private List<OrderItem> orderItems;
	private OrderShipping orderShipping;
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public OrderShipping getOrderShipping() {
		return orderShipping;
	}
	public void setOrderShipping(OrderShipping orderShipping) {
		this.orderShipping = orderShipping;
	}
	
	
}
