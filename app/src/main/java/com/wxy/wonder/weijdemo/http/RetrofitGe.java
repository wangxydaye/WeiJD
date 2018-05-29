package com.wxy.wonder.weijdemo.http;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitGe {
    private static RetrofitGe retrofigUtil;
    private final Retrofit retrofit;
    //单例
    public static RetrofitGe getInstence(){
        if(retrofigUtil==null){
            retrofigUtil = new RetrofitGe();
        }
        return retrofigUtil;
    }
    //初始化
    public RetrofitGe(){
        OkHttpClient build = new OkHttpClient.Builder().build();
        retrofit = new Retrofit.Builder()
                .baseUrl(HttpConfig.ge_url)
                .client(build)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }
    public <T> T createRequest(Class<T> clz){
        T t = retrofit.create(clz);
        return t;
    }
}
