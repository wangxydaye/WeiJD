package com.wxy.wonder.weijdemo.model.fenl;

import android.util.Log;


import com.wxy.wonder.weijdemo.util.HttpUtils;
import com.wxy.wonder.weijdemo.util.OkLoadListener;

import java.util.Map;

/**
 * Created by wonder on 2018/4/29.
 */

public class FenlModelImpl implements FenlModel {
    private static final String TAG = "IModelImpl=====";
    @Override
    public void getLeftList(String url, Map<String, String> map, final GetLeftListener getLeftListener) {
        HttpUtils httpUtils = HttpUtils.getHttpUtils();
        httpUtils.okPost(url,map);
        httpUtils.setOkLoadListener(new OkLoadListener() {
            @Override
            public void okLoadSuccess(String json) {
                Log.d(TAG, "okLoadSuccess: "+json);
                getLeftListener.getLeftSuccess(json);
            }

            @Override
            public void okLoadError(String error) {
               getLeftListener.getLeftError(error);
            }
        });
    }


    @Override
    public void getRightList(String url, Map<String, String> map, final GetRightListener getRightListener) {
        HttpUtils httpUtils = HttpUtils.getHttpUtils();
        httpUtils.okPost(url,map);
        httpUtils.setOkLoadListener(new OkLoadListener() {
            @Override
            public void okLoadSuccess(String json) {
                Log.d(TAG, "okLoadSuccess: "+json);
                getRightListener.getRightSuccess(json);
            }

            @Override
            public void okLoadError(String error) {
                getRightListener.getRightError(error);
            }
        });
    }
}
