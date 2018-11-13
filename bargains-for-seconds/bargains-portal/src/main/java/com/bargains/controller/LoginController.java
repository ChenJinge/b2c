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
@RequestMapping("login")
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "toRegister")
    public String toRegister() {
        return "user/to_register";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(HttpServletRequest req, UserEntity userEntity) {
        userService.insertUser(userEntity);
        HttpSession sess = req.getSession();
        sess.setAttribute("user", userEntity);
        System.out.println(userEntity);
        return "home_page/home_page";
    }

    @RequestMapping(value = "toLogin")
    public String tologin(HttpServletRequest req, UserEntity userEntity) {

        return "user/to_login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(HttpServletRequest req, UserEntity userEntity) {
        String returnurl = "home_page/error";
        String account = userEntity.getAccount();
        String password = userEntity.getPassword();
        UserEntity msuserresult = userService.queryUserByAccount(account);
        if (msuserresult == null) {
            System.out.println("");
            req.setAttribute("errorinfo", "");
        } else if (!msuserresult.getPassword().equals(password)) {
            System.out.println("");
            req.setAttribute("errorinfo", "");
        } else {
            HttpSession sess = req.getSession();
            sess.setAttribute("user", msuserresult);
            returnurl = "home_page/home_page";
        }
        return returnurl;
    }

    @RequestMapping(value = "exit")
    public String exit(HttpServletRequest req) {
        HttpSession session = req.getSession();
        session.removeAttribute("user");
        return "home_page/home_page";
    }

}
