package com.b2c.portal.service;

import com.b2c.common.pojo.ResponseResult;
import com.b2c.portal.pojo.CartItem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface CartService {

    ResponseResult addCartItem(long itemId, int num, HttpServletRequest request, HttpServletResponse response);

    List<CartItem> getCartItemList(HttpServletRequest request, HttpServletResponse response);

    ResponseResult deleteCartItem(long itemId, HttpServletRequest request, HttpServletResponse response);
}
