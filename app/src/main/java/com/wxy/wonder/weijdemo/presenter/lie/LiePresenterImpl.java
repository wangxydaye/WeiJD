package com.wxy.wonder.weijdemo.presenter.lie;

import com.wxy.wonder.weijdemo.bean.LieBean;
import com.wxy.wonder.weijdemo.model.lie.LieModel;
import com.wxy.wonder.weijdemo.view.LieView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LiePresenterImpl implements LiePresenter {
    private LieView lieView;
    @Override
    public void showToLie(LieModel lieModel, LieView lieView) {
             this.lieView=lieView;
        Map<String,String> map=new HashMap<>();
        map.put("pscid","1");
        lieModel.getLieGoodsList(map);
    }

    @Override
    public void getLieDate(List<LieBean.DataBean> list) {
              lieView.lieGoodsList(list);
    }
}
