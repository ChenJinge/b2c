package com.bargains.controller;

import com.bargains.entity.ProductEntity;
import com.bargains.service.ProductService;
import com.bargains.service.redis.ProductRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRedisService productRedisService;

    @RequestMapping(value = "toAddProduct")
    public String toAddProduct(HttpServletRequest req, int productId, int merchantId) {
        req.setAttribute("productId", productId);
        req.setAttribute("merchantId", merchantId);
        return "product/to_add_product";
    }

    @RequestMapping(value = "addProduct", method = RequestMethod.POST)
    public String addProduct(ProductEntity productEntity) {
        productService.insertProduct(productEntity);
        return "redirect:/bargains/listBargains";
    }


    @RequestMapping(value = "queryProductById")
    public String queryProductById(HttpServletRequest req, int productId) {
        ProductEntity productEntity = productRedisService.queryProductById(productId);
        req.setAttribute("product", productEntity);
        return "product/product_view";
    }

    @RequestMapping(value = "toUpdateProduct")
    public String toUpdateProduct(HttpServletRequest req, int productId) {
        ProductEntity productEntity = productService.queryProductById(productId);
        req.setAttribute("product", productEntity);
        return "product/to_update_product";
    }

    @RequestMapping(value = "updateProduct", method = RequestMethod.POST)
    public String updateProduct(HttpServletRequest req, ProductEntity productEntity) {
        productService.updateProduct(productEntity);
        return "redirect:/bargains/listBargains";
    }

}
