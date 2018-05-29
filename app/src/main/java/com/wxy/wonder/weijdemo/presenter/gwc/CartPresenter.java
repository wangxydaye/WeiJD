package com.wxy.wonder.weijdemo.presenter.gwc;

import com.wxy.wonder.weijdemo.bean.gwc.CartBean;
import com.wxy.wonder.weijdemo.model.gwc.CartModel;
import com.wxy.wonder.weijdemo.view.gwc.ICart;
import com.wxy.wonder.weijdemo.view.gwc.OnNetLisenter;

import java.util.ArrayList;
import java.util.List;

/**
 * 购物车的p层
 */
public class CartPresenter {
    private ICart iCart;
    private final CartModel cartModel;

    public CartPresenter(ICart iCart) {
        this.iCart = iCart;
        cartModel = new CartModel();

    }
    public void getCart(){
        cartModel.getCart(3043,"android",new OnNetLisenter<CartBean>(){

            @Override
            public void Success(CartBean cartBean) {
                List<CartBean.DataBean> grouplist = cartBean.getData();
                List<List<CartBean.DataBean.ListBean>> childlist = new ArrayList<>();
                for (int i = 0; i < grouplist.size(); i++) {
                    CartBean.DataBean dataBean = grouplist.get(i);
                    List<CartBean.DataBean.ListBean> list = dataBean.getList();
                    childlist.add(list);
                }
                iCart.showlist(grouplist,childlist);
            }
        });
    }
}
