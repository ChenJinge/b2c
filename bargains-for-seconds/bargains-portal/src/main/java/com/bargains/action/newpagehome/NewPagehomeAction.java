package com.bargains.action.newpagehome;

import com.bargains.enity.BargainsEntity;
import com.bargains.enity.ProductEntity;
import com.bargains.service.BargainsService;
import com.bargains.service.OrderService;
import com.bargains.service.ProductService;
import com.bargains.service.redis.ProductRedisService;
import com.bargains.service.redis.BargainsRedisService;
import com.bargains.vo.bargains.CustomBargains;
import com.bargains.vo.bargains.BargainsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("newpagehomeAction")
public class NewPagehomeAction {

    @Autowired
    private BargainsService bargainsService;

    @Autowired
    private BargainsRedisService bargainsRedisService;

    @Autowired
    private ProductRedisService productRedisService;

    @RequestMapping("index")
    public String index(HttpServletRequest req) {
        BargainsVo bargainsVo = new BargainsVo();
        CustomBargains customBargains = new CustomBargains();
        Date now = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowstring = dateFormat.format(now);
        customBargains.setStartEndTime(nowstring);
        customBargains.setAuditStatus(2);
        bargainsVo.setCustomBargains(customBargains);
//		private Date startstarttime;
//		private Date endstarttime;
        bargainsVo.setCustomBargains(customBargains);
        List<BargainsEntity> list = bargainsService.listProduct(bargainsVo);
        req.setAttribute("list", list);
        return "newhomepage/index";
    }

    @RequestMapping("viewproductdetail")
    public String viewproductdetail(HttpServletRequest req, int id) {
        BargainsEntity msproduct = bargainsRedisService.queryBargainsById(id);
        ProductEntity productEntity = productRedisService.queryProductById(id);
        req.setAttribute("msproduct", msproduct);
        req.setAttribute("productEntity", productEntity);
        return "newhomepage/seckill-item";
    }

}
