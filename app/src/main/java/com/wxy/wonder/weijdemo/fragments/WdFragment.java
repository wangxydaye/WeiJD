package com.wxy.wonder.weijdemo.fragments;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wxy.wonder.weijdemo.R;
import com.wxy.wonder.weijdemo.activitys.JddlActivity;
import com.wxy.wonder.weijdemo.bean.GerenBean;
import com.wxy.wonder.weijdemo.model.geren.GeModelImpl;
import com.wxy.wonder.weijdemo.presenter.geren.GePresenterImpl;
import com.wxy.wonder.weijdemo.view.GeView;

public class WdFragment extends BaseFragment implements GeView {
    private View view;
    private SimpleDraweeView wd_user;
    private TextView tv;

    @Override
    View createView(LayoutInflater inflater) {
        view = View.inflate(getActivity(), R.layout.layout_wd,null);
        tv = view.findViewById(R.id.dlzc);
        wd_user = view.findViewById(R.id.wd_user);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), JddlActivity.class));
                GePresenterImpl gePresenter = new GePresenterImpl();
                gePresenter.showToGe(new GeModelImpl(gePresenter),WdFragment.this);
            }
        });

        return view;
    }

    @Override
    public void showGeList(GerenBean.DataBean list) {
        wd_user.setImageURI(list.getIcon());
        tv.setText(list.getPraiseNum()+"");
    }
}
