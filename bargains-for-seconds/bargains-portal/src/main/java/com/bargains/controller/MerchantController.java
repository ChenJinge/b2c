package com.bargains.controller;

import com.bargains.entity.MerchantEntity;
import com.bargains.service.MerchantService;
import com.bargains.vo.merchant.MerchantVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("merchant")
public class MerchantController {

    @Autowired
    MerchantService merchantService;

    @RequestMapping("toAdd")
    public String toadd() {
        return "merchant/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(MerchantEntity merchantEntity) {
        merchantService.insertMerchant(merchantEntity);
        System.out.println(merchantEntity);
        return "redirect:queryByVo";
    }

    @RequestMapping("toUpdate")
    public String toUpdate(HttpServletRequest request, int id) {
        MerchantEntity merchantEntity = merchantService.queryMerchantById(id);
        request.setAttribute("merchant", merchantEntity);
        return "merchant/update";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(HttpServletRequest request, MerchantEntity merchantEntity) {
        merchantService.updateMerchant(merchantEntity);
        return "redirect:queryByVo";
    }

    @RequestMapping("delete")
    public String del(HttpServletRequest request, int id) {
        merchantService.deleteMerchantById(id);
        return "redirect:queryByVo";
    }

    @RequestMapping("queryById")
    public String queryById(HttpServletRequest request, int id) {
        MerchantEntity merchantEntity = merchantService.queryMerchantById(id);
        request.setAttribute("merchant", merchantEntity);
        return "merchant/view";
    }

    @RequestMapping("queryByVo")
    public String queryByVo(HttpServletRequest request, MerchantVo merchantVo) {
        List<MerchantEntity> list = merchantService.queryMerchantByVo(merchantVo);
        request.setAttribute("merchants", list);
        return "merchant/list";
    }


}
