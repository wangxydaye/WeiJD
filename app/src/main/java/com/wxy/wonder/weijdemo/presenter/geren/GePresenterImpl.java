package com.wxy.wonder.weijdemo.presenter.geren;

import com.wxy.wonder.weijdemo.bean.GerenBean;
import com.wxy.wonder.weijdemo.model.geren.GeModel;
import com.wxy.wonder.weijdemo.view.GeView;

import java.util.HashMap;
import java.util.Map;

public class GePresenterImpl implements GePresenter {
    private GeView geView;
    @Override
    public void showToGe(GeModel geModel, GeView geView) {
                  this.geView=geView;
        Map<String,String> map=new HashMap<>();
        map.put("uid","71");
        geModel.getGeGoodsList(map);
    }

    @Override
    public void getGedate(GerenBean.DataBean list) {
        geView.showGeList(list);
    }
}
