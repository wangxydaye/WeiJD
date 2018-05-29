package com.wxy.wonder.weijdemo.model.geren;

import com.wxy.wonder.weijdemo.bean.GerenBean;
import com.wxy.wonder.weijdemo.http.GeService;
import com.wxy.wonder.weijdemo.http.RetrofitGe;
import com.wxy.wonder.weijdemo.presenter.geren.GePresenter;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class GeModelImpl implements GeModel {
    private GePresenter gePresenter;
    public GeModelImpl(GePresenter gePresenter){
        this.gePresenter=gePresenter;
    }
    @Override
    public void getGeGoodsList(Map<String, String> map) {
        RetrofitGe instence = RetrofitGe.getInstence();
        GeService request = instence.createRequest(GeService.class);
        Observable<GerenBean> geRenList = request.getGeRenList(map);
        geRenList.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GerenBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GerenBean value) {
                        String code = value.getCode();
                        if(code.equals("0")){
                            GerenBean.DataBean data = value.getData();
                            gePresenter.getGedate(data);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
