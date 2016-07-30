package com.jhmedia.master.web;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhmedia.master.PageData;
import com.jhmedia.master.web.base.BaseController;

@Controller
public class LoginCtr extends BaseController{

    Logger logger = LoggerFactory.getLogger(LoginCtr.class);

    @RequestMapping("/login")
    public String login() throws Exception {
        logger.info("LoginCtr login...");
        return "/login.html";
    }

    @RequestMapping("/toLogin")
    @ResponseBody
    public Map<String, String> toLogin() {
        logger.info("LoginCtr toLogin...");
        Map<String, String> rtmap = new HashMap<String, String>();

        PageData pd = this.getPageData();
        rtmap.put("url", "/index");
        return rtmap;
    }
}
