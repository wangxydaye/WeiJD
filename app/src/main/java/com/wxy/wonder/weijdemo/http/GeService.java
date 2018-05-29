package com.wxy.wonder.weijdemo.http;

import com.wxy.wonder.weijdemo.bean.GerenBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface GeService {
    @GET("user/getUserInfo")
    Observable<GerenBean> getGeRenList(@QueryMap Map<String,String> map);
}
