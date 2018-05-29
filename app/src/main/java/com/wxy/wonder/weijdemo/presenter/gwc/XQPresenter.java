package com.wxy.wonder.weijdemo.presenter.gwc;

import com.wxy.wonder.weijdemo.bean.gwc.AddCart;
import com.wxy.wonder.weijdemo.bean.gwc.XQBean;
import com.wxy.wonder.weijdemo.model.gwc.XQModel;
import com.wxy.wonder.weijdemo.view.gwc.IView;
import com.wxy.wonder.weijdemo.view.gwc.OnNetLisenter;

/**
 * 详情页的P层
 */
public class XQPresenter {
    private final XQModel xqModel;
    private IView iView;
    public XQPresenter(IView iView) {
        xqModel = new XQModel();
        this.iView=iView;
    }
    public void getXQ(){
        xqModel.getXQ(12, "android", new OnNetLisenter<XQBean>() {
            @Override
            public void Success(XQBean xqBean) {
                iView.showBean(xqBean);
            }
        });
    }
    public void getAdd(){
        xqModel.getAdd(3043, 12, "android", new OnNetLisenter<AddCart>() {
            @Override
            public void Success(AddCart addCart) {
                iView.showStr(addCart.getMsg());
            }
        });
    }
}
