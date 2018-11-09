package com.bargains.vo.order;

import java.io.Serializable;

public class OrderVo implements Serializable {
    private CustomOrder customOrder;

    public CustomOrder getCustomOrder() {
        return customOrder;
    }

    public void setCustomOrder(CustomOrder customOrder) {
        this.customOrder = customOrder;
    }


}
