package com.bargains.dao;

import com.bargains.enity.ProductEntity;

public interface ProductDao {
     void insertProduct(ProductEntity productEntity);

     ProductEntity queryProductById(int productId);

     void updateProduct(ProductEntity productEntity);
}
