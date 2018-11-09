package com.bargains.action;

import com.bargains.enity.MerchantEntity;
import com.bargains.service.MerchantService;
import com.bargains.vo.merchant.MerchantVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("msmerchantAction")
public class MerchantAction {

    @Autowired
    MerchantService merchantService;

    @RequestMapping("toadd")
    public String toadd() {
        return "msmerchant/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(MerchantEntity merchantEntity) {
        merchantService.insertMerchant(merchantEntity);
        System.out.println(merchantEntity);
        return "redirect:querybyvo";
    }

    @RequestMapping("toupdate")
    public String toupdate(HttpServletRequest request, int id) {
        MerchantEntity merchantEntity = merchantService.queryMerchantById(id);
        request.setAttribute("merchantEntity", merchantEntity);
        return "msmerchant/update";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(HttpServletRequest request, MerchantEntity merchantEntity) {
        merchantService.updateMerchant(merchantEntity);
        return "redirect:querybyvo";
    }

    @RequestMapping("del")
    public String del(HttpServletRequest request, int id) {
        merchantService.deleteMerchantById(id);
        return "redirect:querybyvo";
    }

    @RequestMapping("querybyid")
    public String querybyid(HttpServletRequest request, int id) {
        MerchantEntity merchantEntity = merchantService.queryMerchantById(id);
        request.setAttribute("merchantEntity", merchantEntity);
        return "msmerchant/view";
    }

    @RequestMapping("querybyvo")
    public String querybyvo(HttpServletRequest request, MerchantVo merchantVo) {
        List<MerchantEntity> list = merchantService.queryMerchantByVo(merchantVo);
        request.setAttribute("msmerchantlist", list);
        return "msmerchant/list";
    }


}
