package com.wxy.wonder.weijdemo.view.gwc;

import com.wxy.wonder.weijdemo.bean.gwc.CartBean;

import java.util.List;

public interface ICart {
        void showlist(List<CartBean.DataBean> grouplist, List<List<CartBean.DataBean.ListBean>> childlist);

}
