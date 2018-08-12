package com.liby.springmvc.controller;

import com.liby.springmvc.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    private static Logger logger = Logger.getLogger(UserController.class);
    @RequestMapping(value = "/login",method = {RequestMethod.GET,RequestMethod.POST})
    public String loginView(){
        return "login";
    }
    @RequestMapping("/error")
    public String error(){
        return "error";
    }
    @RequestMapping(value = "/logout")
    public String logoutPage(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication!=null){
            new SecurityContextLogoutHandler().logout(httpServletRequest,httpServletResponse,authentication);
        }
        logger.info("注销登录成功！");
        return "login";
    }
    @RequestMapping(value = "/checkLogin" ,method = RequestMethod.POST)
    public void checkLogin(){
    }
    @RequestMapping(value = "/hello")
    public String hello(HttpServletRequest httpServletRequest){
        System.out.println("This is session:"+httpServletRequest.getSession());
        ModelAndView modelAndView = new ModelAndView("hello");
        logger.info("输出数据："+userService.getUsers().get(0).toString()+"password:");
        return "hello";
    }

}
