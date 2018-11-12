package com.bargains.entity;

import java.io.Serializable;
import java.util.Date;

public class OrderEntity implements Serializable {
    private Integer id;

    private Integer productQuantity;

    private Integer productId;

    private Integer payAmount;

    private Integer userId;

    private Integer merchantId;

    private Date createTime;

    private Date payTime;

    private Integer payType;

    private Integer payStatus;

    private String receivingAddress;

    private String receivingPhone;

    private String receivingName;

    private String tradeSerialNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Integer payAmount) {
        this.payAmount = payAmount;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public String getReceivingAddress() {
        return receivingAddress;
    }

    public void setReceivingAddress(String receivingAddress) {
        this.receivingAddress = receivingAddress;
    }

    public String getReceivingPhone() {
        return receivingPhone;
    }

    public void setReceivingPhone(String receivingPhone) {
        this.receivingPhone = receivingPhone;
    }

    public String getReceivingName() {
        return receivingName;
    }

    public void setReceivingName(String receivingName) {
        this.receivingName = receivingName;
    }

    public String getTradeSerialNumber() {
        return tradeSerialNumber;
    }

    public void setTradeSerialNumber(String tradeSerialNumber) {
        this.tradeSerialNumber = tradeSerialNumber;
    }
}