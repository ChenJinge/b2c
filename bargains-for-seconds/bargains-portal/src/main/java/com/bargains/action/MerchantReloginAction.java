package com.bargains.action;

import com.bargains.enity.MerchantEntity;
import com.bargains.enity.UserEntity;
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
@RequestMapping("msmerchantReloginAction")
public class MerchantReloginAction {

    @Autowired
    MerchantService merchantService;

    @RequestMapping(value = "toregiter")
    public String toregiter() {
        return "msmerchant/toregiter";
    }

    @RequestMapping(value = "regiter", method = RequestMethod.POST)
    public String regiter(HttpServletRequest req, MerchantEntity merchantEntity) {
        merchantService.insertMerchant(merchantEntity);
        HttpSession sess = req.getSession();
        sess.setAttribute("msmerchant", merchantEntity);
        return "adminpagehome/homepage";
    }

    @RequestMapping(value = "tologin")
    public String tologin(HttpServletRequest req, UserEntity userEntity) {

        return "msmerchant/tologin";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(HttpServletRequest req, UserEntity userEntity) {
        String returnurl = "adminpagehome/error";
        String account = userEntity.getAccount();
        String password = userEntity.getPassword();
        MerchantEntity merchantEntity = merchantService.queryMerchantByAccount(account);
        if (merchantEntity == null) {
            req.setAttribute("errorinfo", "�޴��̼�");
        } else if (!merchantEntity.getPassword().equals(password)) {
            req.setAttribute("errorinfo", "�̼��������");
        } else {
            HttpSession sess = req.getSession();
            sess.setAttribute("msmerchant", merchantEntity);
            returnurl = "adminpagehome/homepage";
        }
        return returnurl;
    }

    @RequestMapping(value = "exit")
    public String exit(HttpServletRequest req) {
        HttpSession sess = req.getSession();
        sess.removeAttribute("merchant");
        return "adminpagehome/homepage";
    }


}
