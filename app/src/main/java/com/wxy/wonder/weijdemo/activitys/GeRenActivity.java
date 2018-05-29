package com.wxy.wonder.weijdemo.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wxy.wonder.weijdemo.R;
import com.wxy.wonder.weijdemo.bean.GerenBean;
import com.wxy.wonder.weijdemo.model.geren.GeModelImpl;
import com.wxy.wonder.weijdemo.presenter.geren.GePresenterImpl;
import com.wxy.wonder.weijdemo.view.GeView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GeRenActivity extends Activity implements GeView {

    @BindView(R.id.ren_pic)
    SimpleDraweeView renPic;
    @BindView(R.id.ren_name)
    TextView renName;
    @BindView(R.id.ren_ni)
    TextView renNi;
    @BindView(R.id.ren_sex)
    TextView renSex;
    @BindView(R.id.ren_sheng)
    TextView renSheng;
    private ImageView wd_user;
    private TextView dlzc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ge_ren);
       wd_user = findViewById(R.id.wd_user);
//        dlzc = findViewById(R.id.dlzc);
        ButterKnife.bind(this);
        GePresenterImpl gePresenter = new GePresenterImpl();
        gePresenter.showToGe(new GeModelImpl(gePresenter),this);

    }

    @Override
    public void showGeList(GerenBean.DataBean list) {
        renPic.setImageURI(list.getIcon());
        //renName.setText(list.getNickname());
        renNi.setText(list.getPraiseNum()+"");
        //wd_user.setImageURI();
        //dlzc.setText(list.getNickname());
    }
}
