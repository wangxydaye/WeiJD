package com.wxy.wonder.weijdemo.http.lie;

import com.wxy.wonder.weijdemo.bean.LieBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface LieService {
    @GET("product/getProducts")
    Observable<LieBean> getLie(@QueryMap Map<String,String> map);
}
