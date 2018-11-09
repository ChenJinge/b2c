package com.bargains.service.pay;

public interface OrderToPay {

    int payWithOrder(String tradeSerialNumber, int payAmount);

    int refundWithOrder(String tradeserialNumber, int payAmount);
}
