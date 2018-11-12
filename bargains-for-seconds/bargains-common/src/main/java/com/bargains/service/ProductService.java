package com.bargains.service;

import com.bargains.entity.ProductEntity;

public interface ProductService {

    void insertProduct(ProductEntity productEntity);

    ProductEntity queryProductById(int productid);

    void updateProduct(ProductEntity productEntity);

}
