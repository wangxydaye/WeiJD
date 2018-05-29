package com.wxy.wonder.weijdemo.presenter.shouy;

import android.content.Context;

import com.wxy.wonder.weijdemo.model.shouy.Imode;
import com.wxy.wonder.weijdemo.view.shouy.Iview;

public interface Ipressenter {
    void getmv(Context context, Iview iview, Imode imode);

    void getmv1( Iview iview, Imode imode);
}
