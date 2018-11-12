package com.bargains.controller;

import com.bargains.entity.BargainsEntity;
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
@RequestMapping("bargains")
public class BargainsController {

    @Autowired
    private BargainsService bargainsService;

    @Autowired
    private BargainsRedisService bargainsRedisService;

    @RequestMapping(value = "toApplyBargains")
    public String toApplyBargains() {
        return "bargains/apply_bargains";
    }

    @RequestMapping(value = "applyBargains", method = RequestMethod.POST)
    public String applyBargains(BargainsEntity bargainsEntity) {
        bargainsService.applyProduct(bargainsEntity);
        return "redirect:listProduct";
    }

    @RequestMapping(value = "listBargains")
    public String listBargains(HttpServletRequest req, BargainsVo bargainsVo) {
        List<BargainsEntity> list = bargainsService.listProduct(bargainsVo);
        req.setAttribute("list", list);
        return "bargains/list";
    }


    @RequestMapping(value = "queryBargainsById")
    public String queryBargainsById(HttpServletRequest req, int id) {
        BargainsEntity bargainsEntity = bargainsRedisService.queryBargainsById(id);
        req.setAttribute("bargains", bargainsEntity);
        return "bargains/view";
    }

    @RequestMapping(value = "deleteBargainsById")
    public String deleteBargainsById(HttpServletRequest req, int id) {
        bargainsService.deleteProductById(id);
        return "redirect:listBargains";
    }

    @RequestMapping(value = "toUpdateBargains")
    public String toUpdateBargains(HttpServletRequest req, int id) {
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

        req.setAttribute("bargains", bargainsEntity);
        req.setAttribute("startTime", starttimestring);
        req.setAttribute("endTime", endtimestring);
        return "bargains/update_bargains";
    }

    @RequestMapping(value = "updateBargains", method = RequestMethod.POST)
    public String updateBargains(HttpServletRequest req, BargainsEntity bargainsEntity) {
        bargainsService.updateProduct(bargainsEntity);
        return "redirect:listBargains";
    }

    @RequestMapping(value = "toUpdateBargainsAuditStatus")
    public String toUpdateBargainsAuditStatus(HttpServletRequest req, int id) {
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

        req.setAttribute("bargains", bargainsEntity);
        req.setAttribute("startTime", starttimestring);
        req.setAttribute("endTime", endtimestring);
        return "bargains/audit_bargains";
    }


    @RequestMapping(value = "updateBargainsAuditStatus", method = RequestMethod.POST)
    public String updateBargainsAuditStatus(HttpServletRequest req, int id, int auditStatus) {
        bargainsService.updateProductState(id, auditStatus);
        return "redirect:listBargains";
    }

}
