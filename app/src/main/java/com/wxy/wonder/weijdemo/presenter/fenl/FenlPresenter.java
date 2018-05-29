package com.wxy.wonder.weijdemo.presenter.fenl;


import com.wxy.wonder.weijdemo.model.fenl.FenlModel;
import com.wxy.wonder.weijdemo.view.fenl.FenlView;

/**
 * Created by wonder on 2018/4/29.
 */

public interface FenlPresenter {
    //显示左侧列表
    void showLeftToView(FenlModel iModel, FenlView iView);
    //显示右侧列表
    void showRightToView(FenlModel iModel, FenlView iView);
}
