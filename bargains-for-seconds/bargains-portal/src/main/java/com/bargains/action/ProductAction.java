package com.bargains.action;

import com.bargains.enity.ProductEntity;
import com.bargains.service.ProductService;
import com.bargains.service.redis.ProductRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("msproductDetailAction")
public class ProductAction {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRedisService productRedisService;

    @RequestMapping(value = "toinsertMsproductdetail")
    public String toinsertMsproductdetail(HttpServletRequest req, int productid, int merchantid) {
        req.setAttribute("productid", productid);
        req.setAttribute("merchantid", merchantid);
        return "msproductDetail/toinsertMsproductdetail";
    }

    @RequestMapping(value = "insertMsproductdetail", method = RequestMethod.POST)
    public String insertMsproductdetail(ProductEntity productEntity) {
        productService.insertProduct(productEntity);
        return "redirect:/msproductAction/listmsproduct";
    }


    @RequestMapping(value = "queryMsproductdetailByid")
    public String queryMsproductdetailByid(HttpServletRequest req, int productid) {
        ProductEntity productEntity = productRedisService.queryProductById(productid);
        req.setAttribute("productEntity", productEntity);
        return "msproductDetail/msproductdetailview";
    }

    @RequestMapping(value = "toupdateMsproductdetail")
    public String toupdateMsproductdetail(HttpServletRequest req, int productid) {
        ProductEntity productEntity = productService.queryProductById(productid);
        req.setAttribute("productEntity", productEntity);
        return "msproductDetail/toupdateMsproductdetail";
    }

    @RequestMapping(value = "updateMsproductdetail", method = RequestMethod.POST)
    public String updateMsproductdetail(HttpServletRequest req, ProductEntity productEntity) {
        productService.updateProduct(productEntity);
        return "redirect:/msproductAction/listmsproduct";
    }

}
