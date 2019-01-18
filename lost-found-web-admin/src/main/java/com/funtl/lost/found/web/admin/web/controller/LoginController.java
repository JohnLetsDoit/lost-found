package com.funtl.lost.found.web.admin.web.controller;

import com.funtl.lost.found.commons.constant.ConstantUtils;
import com.funtl.lost.found.domain.User;
import com.funtl.lost.found.web.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


@Controller
public class LoginController{

    @Autowired
    private UserService userService;

    /**跳转登入页面
     *@Author John【chinacode@yeah.net】
     *@Date
     */
    @RequestMapping(value ={"","login"},method = RequestMethod.GET)
    public String login(){
        return "login";
    }
    /**登录逻辑
     *@Author John【chinacode@yeah.net】
     *@Date
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public  String login(@RequestParam(required = true)String email, @RequestParam(required = true)String password, HttpServletRequest httpServletRequest) {

        User user = userService.login(email, password);

        //登录失败
        if (user == null) {
            return login();
        }
        //登陆成功
        else {
            //将登录信息放入回话
            httpServletRequest.getSession().setAttribute(ConstantUtils.SESSION_USER, user);
            return "redirect:/main";
        }
    }
}
