package com.bargains.controller.newpagehome;

import com.bargains.entity.BargainsEntity;
import com.bargains.entity.ProductEntity;
import com.bargains.service.BargainsService;
import com.bargains.service.redis.BargainsRedisService;
import com.bargains.service.redis.ProductRedisService;
import com.bargains.vo.bargains.BargainsVo;
import com.bargains.vo.bargains.CustomBargains;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("newPageHome")
public class NewPageHomeController {

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

        String nowStr = dateFormat.format(now);
        customBargains.setStartEndTime(nowStr);
        customBargains.setAuditStatus(2);
        bargainsVo.setCustomBargains(customBargains);
        List<BargainsEntity> list = bargainsService.listProduct(bargainsVo);
        req.setAttribute("list", list);
        return "new_home_page/index";
    }

    @RequestMapping("viewBargains")
    public String viewBargains(HttpServletRequest req, int id) {
        BargainsEntity bargains = bargainsRedisService.queryBargainsById(id);
        ProductEntity productEntity = productRedisService.queryProductById(id);
        req.setAttribute("bargains", bargains);
        req.setAttribute("product", productEntity);
        return "new_home_page/bargains_item";
    }

}
