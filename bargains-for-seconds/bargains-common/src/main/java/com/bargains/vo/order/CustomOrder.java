package com.bargains.vo.order;

import com.bargains.entity.OrderEntity;

public class CustomOrder extends OrderEntity {
    private int stock;

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
