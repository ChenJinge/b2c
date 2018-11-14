package com.bargains.service.pay;

import org.springframework.stereotype.Service;

@Service
public class UnionPayImpl implements UnionPay {

    public int payWithOrder(String tradeSerialNumber, int payAmount) {
        System.out.println("Union pay succeed ");
        return 1;
    }

    public int refundWithOrder(String tradeSerialNumber, int payAmount) {
        System.out.println("Union refund succeed ");
        return 1;
    }

}
