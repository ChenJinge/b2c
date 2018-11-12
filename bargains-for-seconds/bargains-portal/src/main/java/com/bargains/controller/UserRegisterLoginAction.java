package com.bargains.controller;

import com.bargains.entity.UserEntity;
import com.bargains.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("userregiterloginAction")
public class UserRegisterLoginAction {

    @Autowired
    UserService userService;

    @RequestMapping(value = "toregiter")
    public String toregiter() {
        return "user/to_register";
    }

    @RequestMapping(value = "regiter", method = RequestMethod.POST)
    public String regiter(HttpServletRequest req, UserEntity userEntity) {
        userService.insertUser(userEntity);
        HttpSession sess = req.getSession();
        sess.setAttribute("msuser", userEntity);
        System.out.println(userEntity);
        return "homepage/homepage";
    }

    @RequestMapping(value = "tologin")
    public String tologin(HttpServletRequest req, UserEntity userEntity) {

        return "user/to_login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(HttpServletRequest req, UserEntity userEntity) {
        String returnurl = "homepage/error";
        String account = userEntity.getAccount();
        String password = userEntity.getPassword();
        UserEntity msuserresult = userService.queryUserByAccount(account);
        if (msuserresult == null) {
            System.out.println("�޴��û�");
            req.setAttribute("errorinfo", "�޴��û�");
        } else if (!msuserresult.getPassword().equals(password)) {
            System.out.println("�������");
            req.setAttribute("errorinfo", "�������");
        } else {
            HttpSession sess = req.getSession();
            sess.setAttribute("msuser", msuserresult);
            returnurl = "homepage/homepage";
        }
        return returnurl;
    }

    @RequestMapping(value = "exit")
    public String exit(HttpServletRequest req) {
        HttpSession sess = req.getSession();
        sess.removeAttribute("user");
        return "homepage/homepage";
    }

}
