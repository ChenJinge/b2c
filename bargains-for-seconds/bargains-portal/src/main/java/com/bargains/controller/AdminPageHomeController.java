package com.bargains.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("adminPageHome")
public class AdminPageHomeController {

    @RequestMapping("toHome")
    public String toHome() {
        return "admin_home_page/home_page";
    }
}
