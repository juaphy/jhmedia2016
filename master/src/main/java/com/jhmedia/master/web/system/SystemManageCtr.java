/* =============================================================
 * 工程名称：信息管理系统
 * 对象名称：SystemManageCtr.java
 * 创建时间：2016年8月2日 下午12:00:52
 * (R) Copyright 贵州小小马驹科技有限公司 (广州市番禺区大石镇植村村东南大街5号)
 * =============================================================
 */
package com.jhmedia.master.web.system;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jhmedia.master.service.system.ZhglService;
import com.jhmedia.master.state.ZhglState;
import com.jhmedia.master.util.Page;
import com.jhmedia.master.util.PageData;
import com.jhmedia.master.web.base.BaseController;

/**
 * 系统管理
 * 
 * <pre>
 * 概要: 系统管理Ctr
 * 更新: 2016年8月2日 下午12:00:52
 * 作者: seki
 * 版本: $Rev$
 * ID  ：$Id$
 * </pre>
 */
@Controller
@RequestMapping("/system_manage")
public class SystemManageCtr extends BaseController {

    @Resource(name = "ZhglServiceImpl")
    private ZhglService zhglService;

    @RequestMapping("/zhgl")
    public ModelAndView index(Page page) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<PageData> list = zhglService.findZhListPage(page);
        for (PageData pd : list) {

            // 操作
            pd.put("cz", String.valueOf(pd.get("zhzt")));

            // 账号类型
            pd.put("zhlx", ZhglState.codeToDescByZhlx(String.valueOf(pd.get("zhlx"))));

            // 账号状态
            pd.put("zhzt", ZhglState.codeToDescByZhzt(String.valueOf(pd.get("zhzt"))));

        }
        mv.setViewName("/system/zhgl/index.html");
        mv.addObject("list", list);
        return mv;
    }

    @RequestMapping("/toUpdateZt")
    @ResponseBody
    public PageData toUpdateZt() {
        PageData pd = this.getPageData();
        try {
            zhglService.updateZhzt(pd);
            pd.put("result", pd.getString("cz"));
        } catch (Exception e) {
            e.printStackTrace();
            pd.put("errormessage", "更新账号状态时发生异常");
        }
        return pd;
    }
}
