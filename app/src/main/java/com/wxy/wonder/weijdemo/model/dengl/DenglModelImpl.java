package com.wxy.wonder.weijdemo.model.dengl;

import android.util.Log;

import com.google.gson.Gson;
import com.wxy.wonder.weijdemo.bean.LoginBean;
import com.wxy.wonder.weijdemo.bean.RegBean;
import com.wxy.wonder.weijdemo.util.HttpUtils;
import com.wxy.wonder.weijdemo.util.OkLoadListener;

import java.util.Map;

import static android.content.ContentValues.TAG;

public class DenglModelImpl implements DenglModel {
    @Override
    public void login(String url, Map<String, String> parms, final LoginListener loginListener) {
        HttpUtils httpUtils = HttpUtils.getHttpUtils();
        httpUtils.okPost(url,parms);
        httpUtils.setOkLoadListener(new OkLoadListener() {
            @Override
            public void okLoadSuccess(String json) {
                Log.d(TAG, "LoadSuccess: "+json);
                Gson gson=new Gson();
                LoginBean loginBean = gson.fromJson(json, LoginBean.class);
                if(loginBean.getCode().equals("0")){
                    loginListener.loginSuccess(json);
                }else {
                    loginListener.loginError(json);
                }

            }

            @Override
            public void okLoadError(String error) {
                loginListener.loginError(error);
            }
        });
    }

    @Override
    public void Reg(String url, Map<String, String> parms, final LoginListener loginListener) {
        HttpUtils httpUtils = HttpUtils.getHttpUtils();
        httpUtils.okPost(url,parms);
        httpUtils.setOkLoadListener(new OkLoadListener() {
            @Override
            public void okLoadSuccess(String json) {
                Log.d(TAG, "LoadSuccess: "+json);
                Gson gson=new Gson();
                RegBean regBean = gson.fromJson(json, RegBean.class);
                if(regBean.getCode().equals("0")){
                    loginListener.loginSuccess(json);
                }else {
                    loginListener.loginError(json);
                }

            }

            @Override
            public void okLoadError(String error) {
                loginListener.loginError(error);
            }
        });
    }
}
