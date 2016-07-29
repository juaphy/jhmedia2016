package com.jhmedia.master.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhmedia.master.web.base.BaseController;

@Controller
public class IndexCtrl extends BaseController {

    @RequestMapping("/index")
    public String index() throws Exception {
        return "/index.html";
    }
}
