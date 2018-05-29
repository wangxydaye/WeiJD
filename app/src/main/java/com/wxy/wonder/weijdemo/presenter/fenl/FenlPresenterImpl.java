package com.wxy.wonder.weijdemo.presenter.fenl;

import android.util.Log;

import com.google.gson.Gson;
import com.wxy.wonder.weijdemo.bean.fenl.LeftBean;
import com.wxy.wonder.weijdemo.bean.fenl.RightBean;
import com.wxy.wonder.weijdemo.http.HttpConfig;
import com.wxy.wonder.weijdemo.model.fenl.FenlModel;
import com.wxy.wonder.weijdemo.model.fenl.GetLeftListener;
import com.wxy.wonder.weijdemo.model.fenl.GetRightListener;
import com.wxy.wonder.weijdemo.view.fenl.FenlView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wonder on 2018/4/29.
 */

public class FenlPresenterImpl implements FenlPresenter {
    private static final String TAG = "IPresenterImpl";
    @Override
    public void showLeftToView(FenlModel iModel, final FenlView iView) {
        Map<String, String> map = new HashMap<>();
        iModel.getLeftList(HttpConfig.left_url, map, new GetLeftListener() {
            @Override
            public void getLeftSuccess(String json) {
                Log.d(TAG, "左侧-----: "+json);
                //解析
                Gson gson = new Gson();
                LeftBean leftBean = gson.fromJson(json, LeftBean.class);
                if (leftBean.getCode().equals("0")) {
                    iView.showLeftView(leftBean.getData());
                } else {
                    Log.d(TAG, "失败" + json);
                }
            }

            @Override
            public void getLeftError(String error) {
                Log.d(TAG, "getLeftError: " + error);
            }
        });
    }

    @Override
    public void showRightToView(FenlModel iModel, final FenlView iView) {
        Map<String, String> map = new HashMap<>();
        map.put("cid",iView.getCid());
        iModel.getRightList(HttpConfig.right_url, map, new GetRightListener() {
            @Override
            public void getRightSuccess(String json) {
                Log.d(TAG, "右侧----: "+json);
                //解析
                Gson gson = new Gson();
                RightBean rightBean = gson.fromJson(json, RightBean.class);
                if (rightBean.getCode().equals("0")) {
                    iView.showRightView(rightBean.getData());
                } else {
                    Log.d(TAG, "失败" + json);
                }
            }

            @Override
            public void getRightError(String error) {
                Log.d(TAG, "getLeftError: " + error);
            }
        });
    }
}
