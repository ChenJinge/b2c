package com.bargains.vo.merchant;

import java.io.Serializable;

public class MerchantVo implements Serializable {
    private CustomMerchantEntity customMerchantEntity;

    public CustomMerchantEntity getCustomMerchantEntity() {
        return customMerchantEntity;
    }

    public void setCustomMerchantEntity(CustomMerchantEntity customMerchantEntity) {
        this.customMerchantEntity = customMerchantEntity;
    }
}
