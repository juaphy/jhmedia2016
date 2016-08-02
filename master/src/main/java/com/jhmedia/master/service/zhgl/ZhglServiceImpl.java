/* =============================================================
 * 工程名称：信息管理系统
 * 对象名称：ZhglServiceImpl.java
 * 创建时间：2016年8月2日 下午7:36:31
 * (R) Copyright 贵州小小马驹科技有限公司 (广州市番禺区大石镇植村村东南大街5号)
 * =============================================================
 */
package com.jhmedia.master.service.zhgl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jhmedia.master.service.common.BaseServiceImpl;
import com.jhmedia.master.util.Page;
import com.jhmedia.master.util.PageData;

/**
 * TODO
 * <pre>
 * 概要: TODO
 * 更新: 2016年8月2日 下午7:36:31
 * 作者: seki
 * 版本: $Rev$
 * ID  ：$Id$
 * </pre>
 */
@Service("zhglServiceImpl")
public class ZhglServiceImpl extends BaseServiceImpl implements ZhglService {

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<PageData> findZhListPage(Page page) throws Exception {
        return (List<PageData>) this.daoSupport.findForList("ZhglMapper.zhlistPage", page);
    }

}
