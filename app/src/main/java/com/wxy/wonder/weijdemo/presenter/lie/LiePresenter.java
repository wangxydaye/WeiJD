package com.wxy.wonder.weijdemo.presenter.lie;

import com.wxy.wonder.weijdemo.bean.LieBean;
import com.wxy.wonder.weijdemo.model.lie.LieModel;
import com.wxy.wonder.weijdemo.view.LieView;

import java.util.List;

public interface LiePresenter {
    void showToLie(LieModel lieModel, LieView lieView);
    void getLieDate(List<LieBean.DataBean> list);
}
