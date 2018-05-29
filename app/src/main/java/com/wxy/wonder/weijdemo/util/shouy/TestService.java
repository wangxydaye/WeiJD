package com.wxy.wonder.weijdemo.util.shouy;

import com.wxy.wonder.weijdemo.bean.shouy.Jiugongge_bean;
import com.wxy.wonder.weijdemo.bean.shouy.Shouye_bean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface TestService {
    @GET("ad/getAd")
    Observable<Shouye_bean> getUser();

    @GET("product/getCatagory")
    Observable<Jiugongge_bean> getjiugongge();
}
