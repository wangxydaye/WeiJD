package com.wxy.wonder.weijdemo.presenter.dengl;

import com.wxy.wonder.weijdemo.model.dengl.DenglModel;
import com.wxy.wonder.weijdemo.view.dengl.DenglView;
import com.wxy.wonder.weijdemo.view.dengl.ZhucView;

public interface DenglPresenter {
    void loginPresenter(DenglModel denglModel, DenglView denglView);
    void RegPresenter(DenglModel denglModel, ZhucView zhucView);
}
