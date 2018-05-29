package com.wxy.wonder.weijdemo.presenter.shouy;

import android.content.Context;

import com.wxy.wonder.weijdemo.bean.shouy.Jiugongge_bean;
import com.wxy.wonder.weijdemo.bean.shouy.Shouye_bean;
import com.wxy.wonder.weijdemo.model.shouy.Getjiugongge;
import com.wxy.wonder.weijdemo.model.shouy.Getjson;
import com.wxy.wonder.weijdemo.model.shouy.Imode;
import com.wxy.wonder.weijdemo.view.shouy.Iview;

import java.util.List;

public class Mypresenter implements Ipressenter {
    @Override
    public void getmv(final Context context, final Iview iview, Imode imode) {
        imode.getnetjson(new Getjson() {
            @Override
            public void getnetjson(Shouye_bean shouye_bean) {
                iview.setadapter(context,shouye_bean);
            }
        });
    }


    @Override
    public void getmv1(final Iview iview, final Imode imode) {
        imode.getjiugonggejson(new Getjiugongge() {
            @Override
            public void getJiugongge(List<Jiugongge_bean.DataBean> data) {
                iview.setadapter1(data);
            }
        });
    }
}
