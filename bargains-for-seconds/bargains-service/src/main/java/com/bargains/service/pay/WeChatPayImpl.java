package com.bargains.service.pay;

import org.springframework.stereotype.Service;

@Service
public class WeChatPayImpl implements WeChatPay {

    public int payWithOrder(String tradeSerialNumber, int payAmount) {
        System.out.println("WeChat pay succeed ");
        return 1;
    }

    public int refundWithOrder(String tradeSerialNumber, int payAmount) {
        System.out.println("WeChat refund succeed ");
        return 1;
    }

}
