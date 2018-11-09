package com.bargains.service;

import com.bargains.dao.ProductDao;
import com.bargains.enity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    public void insertProduct(ProductEntity productEntity) {
        productDao.insertProduct(productEntity);
    }

    public ProductEntity queryProductById(int productId) {
        return productDao.queryProductById(productId);
    }

    public void updateProduct(ProductEntity productEntity) {
        productDao.updateProduct(productEntity);
    }

}
