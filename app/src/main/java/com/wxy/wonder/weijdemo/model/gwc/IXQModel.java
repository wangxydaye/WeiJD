package com.wxy.wonder.weijdemo.model.gwc;

import com.wxy.wonder.weijdemo.bean.gwc.XQBean;
import com.wxy.wonder.weijdemo.view.gwc.OnNetLisenter;

/**
 * 实现详情页model层的接口
 */
public interface IXQModel {
    public void getXQ(int pid, String str, final OnNetLisenter<XQBean> cgsb);
}
