package com.bargains.service.pay;

import org.springframework.stereotype.Service;

@Service
public class WeChatPayImpl implements WeChatPay {

    public int payWithOrder(String tradeserialnumber, int payamount) {
        System.out.println("΢��֧���ɹ�");
        return 1;
    }

    public int refundWithOrder(String tradeserialnumber, int payamount) {
        System.out.println("΢���˿�ɹ�");
        return 1;
    }

}
