package com.bargains.controller;

import com.bargains.entity.UserEntity;
import com.bargains.service.UserService;
import com.bargains.vo.user.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping("toAdd")
    public String toAdd() {
        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(UserEntity userEntity) {
        userService.insertUser(userEntity);
        System.out.println(userEntity);
        return "redirect:queryByVo";
    }

    @RequestMapping("toUpdate")
    public String toUpdate(HttpServletRequest request, int id) {
        UserEntity user = userService.queryUserById(id);
        request.setAttribute("user", user);
        return "user/update";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(HttpServletRequest request, UserEntity userEntity) {
        userService.updateUser(userEntity);
        System.out.println(userEntity);
        return "redirect:queryByVo";
    }

    @RequestMapping("delete")
    public String delete(HttpServletRequest request, int id) {
        userService.deleteUserById(id);
        return "redirect:queryByVo";
    }

    @RequestMapping("querybyId")
    public String querybyid(HttpServletRequest request, int id) {
        UserEntity userEntity = userService.queryUserById(id);
        request.setAttribute("user", userEntity);
        return "user/view";
    }

    @RequestMapping("queryByVo")
    public String queryByVo(HttpServletRequest request, UserVo userVo) {
        List<UserEntity> list = userService.queryUserByVo(userVo);
        request.setAttribute("users", list);
        return "user/list";
    }


}
