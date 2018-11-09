package com.bargains.service.pay;

import org.springframework.stereotype.Service;

@Service
public class AliPayImpl implements AliPay {

    public int payWithOrder(String tradeserialnumber, int payamount) {
        System.out.println("֧����֧���ɹ�");
        return 1;
    }

    public int refundWithOrder(String tradeserialnumber, int payamount) {
        System.out.println("֧�����˿�ɹ�");
        return 1;
    }

}
