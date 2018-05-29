package com.wxy.wonder.weijdemo.model.gwc;

import com.wxy.wonder.weijdemo.bean.gwc.AddCart;
import com.wxy.wonder.weijdemo.bean.gwc.XQBean;
import com.wxy.wonder.weijdemo.http.RetrofitHepler;
import com.wxy.wonder.weijdemo.view.gwc.OnNetLisenter;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 实现详情页model
 */
public class XQModel implements IXQModel{

    @Override
    public void getXQ(int pid, String str, final OnNetLisenter<XQBean> onNetLisenter) {
        Flowable<XQBean> flowable = RetrofitHepler.getSerViceAPI().getXQ(pid, str);
        flowable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<XQBean>() {
                    @Override
                    public void accept(XQBean xqBean) throws Exception {
                        onNetLisenter.Success(xqBean);
                    }
                });
    }

    public void getAdd(int uid, int pid, String str, final OnNetLisenter<AddCart> onNetLisenter){
        Flowable<AddCart> flowable = RetrofitHepler.getSerViceAPI().getMsg(uid, pid, str);
        flowable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<AddCart>() {
                    @Override
                    public void accept(AddCart addCart) throws Exception {
                        onNetLisenter.Success(addCart);
                    }
                });
    }
}
