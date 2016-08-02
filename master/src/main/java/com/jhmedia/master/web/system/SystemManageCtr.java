/* =============================================================
 * 工程名称：信息管理系统
 * 对象名称：SystemManageCtr.java
 * 创建时间：2016年8月2日 下午12:00:52
 * (R) Copyright 贵州小小马驹科技有限公司 (广州市番禺区大石镇植村村东南大街5号)
 * =============================================================
 */
package com.jhmedia.master.web.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhmedia.master.web.base.BaseController;

/**
 * 系统管理
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

    @RequestMapping("/zhgl")
    public String index() {
        return "/system/zhgl/index.html";
    }

}
