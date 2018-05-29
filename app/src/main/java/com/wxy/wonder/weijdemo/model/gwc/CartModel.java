package com.wxy.wonder.weijdemo.model.gwc;

import com.wxy.wonder.weijdemo.bean.gwc.CartBean;
import com.wxy.wonder.weijdemo.http.RetrofitHepler;
import com.wxy.wonder.weijdemo.view.gwc.OnNetLisenter;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 购物车的model
 */
public class CartModel {
    public void getCart(int uid, String str, final OnNetLisenter<CartBean> onNetLisenter){
        Flowable<CartBean> flowable = RetrofitHepler.getSerViceAPI().getCart(uid,str);
        flowable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<CartBean>() {
                    @Override
                    public void accept(CartBean cartBean) throws Exception {
                        onNetLisenter.Success(cartBean);
                    }
                });
    }
}
