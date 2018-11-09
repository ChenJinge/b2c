package com.bargains.service;

import com.bargains.enity.BargainsEntity;
import com.bargains.vo.bargains.BargainsVo;

import java.util.List;

public interface BargainsService {

    void applyProduct(BargainsEntity bargainsEntity);

    List<BargainsEntity> listProduct(BargainsVo bargainsVo);

    BargainsEntity queryProductById(int id);

    void deleteProductById(int id);

    void updateProduct(BargainsEntity bargainsEntity);

    void updateProductState(int id, int state);
}
