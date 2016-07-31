package com.jhmedia.master.web;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhmedia.master.PageData;
import com.jhmedia.master.util.Const;
import com.jhmedia.master.util.StringUtil;
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
        
        String username = pd.getString("yhm");
        String password = pd.getString("mm");
        String code = pd.getString("scode");
        String sessionCode = (String) getRequest().getSession().getAttribute(
                Const.SESSION_SECURITY_CODE);
        if (StringUtil.isEmpty(sessionCode)
                || !sessionCode.toUpperCase().equals(code.toUpperCase())) {
            rtmap.put("message", "验证码输入错误");
            return rtmap;
        }
        getRequest().getSession().setAttribute(Const.SESSION_USER, "admin");
        rtmap.put("url", "/index");
        return rtmap;
    }
}
