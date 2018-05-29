package com.wxy.wonder.weijdemo.http.lie;

import com.wxy.wonder.weijdemo.http.HttpConfig;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class LieRetrofit {
    private static LieRetrofit retrofigUtil;
    private final Retrofit retrofit;
    //单例
    public static LieRetrofit getInstence(){
        if(retrofigUtil==null){
            retrofigUtil = new LieRetrofit();
        }
        return retrofigUtil;
    }
    //初始化
    public LieRetrofit(){
        OkHttpClient build = new OkHttpClient.Builder().build();
        retrofit = new Retrofit.Builder()
                .baseUrl(HttpConfig.lie_url)
                .client(build)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public <T> T createRequest(Class<T> clz){
        T t = retrofit.create(clz);
        return t;
    }
}
