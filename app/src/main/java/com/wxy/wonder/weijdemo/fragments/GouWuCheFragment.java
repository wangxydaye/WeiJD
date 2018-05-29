package com.wxy.wonder.weijdemo.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.wxy.wonder.weijdemo.R;
import com.wxy.wonder.weijdemo.activitys.MessgeEvent;
import com.wxy.wonder.weijdemo.adapter.fenl.gwc.MyExpandableAdapter;
import com.wxy.wonder.weijdemo.bean.gwc.CartBean;
import com.wxy.wonder.weijdemo.bean.gwc.CountAndPrice;
import com.wxy.wonder.weijdemo.presenter.gwc.CartPresenter;
import com.wxy.wonder.weijdemo.view.gwc.ICart;

import java.util.List;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;


public class GouWuCheFragment extends BaseFragment implements ICart {
    private ExpandableListView mElv;
    private CheckBox mQuanxuan;
    private TextView mZongjia;
    private TextView mTvCount;
    private MyExpandableAdapter myExpandableAdapter;
    private View view;
    @Override
    View createView(LayoutInflater inflater) {
        view = View.inflate(getActivity(), R.layout.layout_gwc,null);
        initView();
        new CartPresenter(this).getCart();
        EventBus.getDefault().register(this);
        mQuanxuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myExpandableAdapter.qx(mQuanxuan.isChecked());
            }
        });
        return view;
    }
    private void initView() {
        mElv = (ExpandableListView)view. findViewById(R.id.elv);
        mQuanxuan = (CheckBox) view.findViewById(R.id.quanxuan);
        mZongjia = (TextView) view.findViewById(R.id.zongjia);
        mTvCount = (TextView)view. findViewById(R.id.tv_count);
    }

    @Override
    public void showlist(List<CartBean.DataBean> grouplist, List<List<CartBean.DataBean.ListBean>> childlist) {
        myExpandableAdapter = new MyExpandableAdapter(grouplist, getContext(),childlist);
        mElv.setAdapter(myExpandableAdapter);
        for (int i = 0; i <grouplist.size() ; i++) {
            mElv.expandGroup(i);
        }
    }

    //接收传过来的值
    @Subscribe
    public void onPriceAndCount(CountAndPrice cp){


        mZongjia.setText("共"+cp.getCount()+"件商品");
        mTvCount.setText("总计："+cp.getPrice());

    }
    //接收传过来的值
    @Subscribe
    public void onPriceAndCount1(MessgeEvent event){
        //改变全选的状态
        mQuanxuan.setChecked(event.isCheck());
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
