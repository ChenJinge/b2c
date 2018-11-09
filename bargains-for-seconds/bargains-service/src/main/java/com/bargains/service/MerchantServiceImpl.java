package com.bargains.service;

import com.bargains.dao.MerchantDao;
import com.bargains.enity.MerchantEntity;
import com.bargains.vo.merchant.MerchantVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    MerchantDao merchantDao;

    public void insertMerchant(MerchantEntity merchantEntity) {
        merchantDao.insertMerchant(merchantEntity);
    }

    public MerchantEntity queryMerchantById(int id) {
        return merchantDao.queryMerchantById(id);
    }

    public void updateMerchant(MerchantEntity merchantEntity) {
        merchantDao.updateMerchant(merchantEntity);
    }

    public void deleteMerchantById(int id) {
        merchantDao.deleteMerchantById(id);
    }

    public List<MerchantEntity> queryMerchantByVo(MerchantVo merchantVo) {
        return merchantDao.queryMerchantByVo(merchantVo);
    }

    public MerchantEntity queryMerchantByAccount(String account) {
        return merchantDao.queryMerchantByAccount(account);
    }
}
