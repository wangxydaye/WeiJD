package com.wxy.wonder.weijdemo.presenter.geren;

import com.wxy.wonder.weijdemo.bean.GerenBean;
import com.wxy.wonder.weijdemo.model.geren.GeModel;
import com.wxy.wonder.weijdemo.view.GeView;

public interface GePresenter {
    void showToGe(GeModel geModel, GeView geView);
    void getGedate( GerenBean.DataBean list);
}
