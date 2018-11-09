package com.bargains.service;

import com.bargains.enity.MerchantEntity;
import com.bargains.vo.merchant.MerchantVo;

import java.util.List;

public interface MerchantService {

    void insertMerchant(MerchantEntity merchantEntity);

    MerchantEntity queryMerchantById(int id);

    void updateMerchant(MerchantEntity merchantEntity);

    void deleteMerchantById(int id);

    List<MerchantEntity> queryMerchantByVo(MerchantVo merchantVo);

    MerchantEntity queryMerchantByAccount(String account);
}
