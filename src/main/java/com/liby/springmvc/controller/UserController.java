package com.liby.springmvc.controller;

import com.liby.springmvc.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    private static Logger logger = Logger.getLogger(UserController.class);
    @RequestMapping("/getUsers")
    public ModelAndView getUsers(){
        ModelAndView modelAndView = new ModelAndView("index");
        logger.debug(userService.getUsers().get(0).toString());
        return modelAndView;
    }
}
