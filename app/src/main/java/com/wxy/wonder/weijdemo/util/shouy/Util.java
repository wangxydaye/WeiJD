package com.wxy.wonder.weijdemo.util.shouy;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/5/21
 */

public class Util {
    private volatile static Util util = null;

    private Util() {

    }

    public static Util getmInstance() {
        if (util == null) {
            synchronized (Util.class) {
                if (util == null) {
                    util = new Util();
                }
            }
        }
        return util;
    }

    public TestService getnetjson(String uri) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(uri)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        TestService testservive = retrofit.create(TestService.class);
        return testservive;

    }
}
