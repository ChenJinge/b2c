package com.bargains.controller;

import com.bargains.entity.MerchantEntity;
import com.bargains.entity.UserEntity;
import com.bargains.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * �̼�ע���¼ģ��
 *
 * @author Administrator
 */
@Controller
@RequestMapping("merchantRelogin")
public class MerchantReloginController {

    @Autowired
    MerchantService merchantService;

    @RequestMapping(value = "toRegister")
    public String toRegister() {
        return "merchant/to_register";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String regiter(HttpServletRequest req, MerchantEntity merchantEntity) {
        merchantService.insertMerchant(merchantEntity);
        HttpSession sess = req.getSession();
        sess.setAttribute("merchant", merchantEntity);
        return "admin_page_home/home_page";
    }

    @RequestMapping(value = "toLogin")
    public String tologin(HttpServletRequest req, UserEntity userEntity) {

        return "merchant/to_login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(HttpServletRequest req, UserEntity userEntity) {
        String returnUrl = "admin_page_home/error";
        String account = userEntity.getAccount();
        String password = userEntity.getPassword();
        MerchantEntity merchantEntity = merchantService.queryMerchantByAccount(account);
        if (merchantEntity == null) {
            req.setAttribute("errorinfo", "account not exist");
        } else if (!merchantEntity.getPassword().equals(password)) {
            req.setAttribute("errorinfo", "password invalid");
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("merchant", merchantEntity);
            returnUrl = "admin_home_page/home_page";
        }
        return returnUrl;
    }

    @RequestMapping(value = "exit")
    public String exit(HttpServletRequest req) {
        HttpSession session = req.getSession();
        session.removeAttribute("merchant");
        return "admin_home_page/home_page";
    }


}
