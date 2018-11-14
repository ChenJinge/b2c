package com.bargains.service.pay;

import org.springframework.stereotype.Service;

@Service
public class AliPayImpl implements AliPay {
    public int payWithOrder(String tradeSerialNumber, int payAmount) {
        System.out.println("Ali pay succeed ");
        return 1;
    }

    public int refundWithOrder(String tradeSerialNumber, int payAmount) {
        System.out.println("Ali refund succeed ");
        return 1;
    }

}
