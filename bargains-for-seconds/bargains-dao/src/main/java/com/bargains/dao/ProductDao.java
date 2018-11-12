package com.bargains.dao;

import com.bargains.entity.ProductEntity;

public interface ProductDao {
     void insertProduct(ProductEntity productEntity);

     ProductEntity queryProductById(int productId);

     void updateProduct(ProductEntity productEntity);
}
