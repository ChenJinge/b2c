package com.bargains.action;

import com.bargains.enity.BargainsEntity;
import com.bargains.service.BargainsService;
import com.bargains.service.redis.BargainsRedisService;
import com.bargains.vo.bargains.BargainsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("msproductAction")
public class BargainsAction {

    @Autowired
    private BargainsService bargainsService;

    @Autowired
    private BargainsRedisService bargainsRedisService;

    @RequestMapping(value = "toApplymsproduct")
    public String toApplymsproduct() {
        return "msproductinfo/applymsproduct";
    }

    @RequestMapping(value = "applymsproduct", method = RequestMethod.POST)
    public String applymsproduct(BargainsEntity bargainsEntity) {
        bargainsService.applyProduct(bargainsEntity);
        return "redirect:listProduct";
    }

    @RequestMapping(value = "listmsproduct")
    public String listmsproduct(HttpServletRequest req, BargainsVo bargainsVo) {
        List<BargainsEntity> list = bargainsService.listProduct(bargainsVo);
        req.setAttribute("list", list);
        return "msproductinfo/list";
    }


    @RequestMapping(value = "querymsproductByid")
    public String querymsproductByid(HttpServletRequest req, int id) {
        BargainsEntity bargainsEntity = bargainsRedisService.queryBargainsById(id);
        req.setAttribute("bargainsEntity", bargainsEntity);
        return "msproductinfo/view";
    }

    @RequestMapping(value = "deletemsproductByid")
    public String deletemsproductByid(HttpServletRequest req, int id) {
        bargainsService.deleteProductById(id);
        return "redirect:listProduct";
    }

    @RequestMapping(value = "toupdatemsproduct")
    public String toupdatemsproduct(HttpServletRequest req, int id) {
        BargainsEntity bargainsEntity = bargainsService.queryProductById(id);
        Date starttime = bargainsEntity.getStartTime();
        Date endtime = bargainsEntity.getEndTime();
        String starttimestring = "";
        String endtimestring = "";
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (starttime != null) {
            starttimestring = dateFormat.format(starttime);
        }
        if (endtime != null) {
            endtimestring = dateFormat.format(endtime);
        }

        req.setAttribute("bargainsEntity", bargainsEntity);
        req.setAttribute("starttimestring", starttimestring);
        req.setAttribute("endtimestring", endtimestring);
        return "msproductinfo/updatemsproduct";
    }

    @RequestMapping(value = "updatemsproduct", method = RequestMethod.POST)
    public String updatemsproduct(HttpServletRequest req, BargainsEntity bargainsEntity) {
        bargainsService.updateProduct(bargainsEntity);
        return "redirect:listProduct";
    }

    @RequestMapping(value = "toupdatemsproductstate")
    public String toupdatemsproductstate(HttpServletRequest req, int id) {
        BargainsEntity bargainsEntity = bargainsService.queryProductById(id);
        Date starttime = bargainsEntity.getStartTime();
        Date endtime = bargainsEntity.getEndTime();
        String starttimestring = "";
        String endtimestring = "";
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (starttime != null) {
            starttimestring = dateFormat.format(starttime);
        }
        if (endtime != null) {
            endtimestring = dateFormat.format(endtime);
        }

        req.setAttribute("bargainsEntity", bargainsEntity);
        req.setAttribute("starttimestring", starttimestring);
        req.setAttribute("endtimestring", endtimestring);
        return "msproductinfo/auditmsproduct";
    }


    @RequestMapping(value = "updatemsproductstate", method = RequestMethod.POST)
    public String updatemsproductstate(HttpServletRequest req, int id, int state) {
        bargainsService.updateProductState(id, state);
        return "redirect:listProduct";
    }

}
