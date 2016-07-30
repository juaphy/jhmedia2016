package com.jhmedia.master.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhmedia.master.web.base.BaseController;

@Controller
public class LoginCtr extends BaseController{

    @RequestMapping("/login")
    public String login() throws Exception {
        return "/login.html";
    }
}
