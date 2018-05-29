package com.wxy.wonder.weijdemo.activitys;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.wxy.wonder.weijdemo.R;
import com.wxy.wonder.weijdemo.fragments.BaseFragment;
import com.wxy.wonder.weijdemo.fragments.FragmentFactory;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements View.OnClickListener{
    private List<TextView> tv_list = new ArrayList<>();
    private List<BaseFragment> list = new ArrayList<>();
    private FragmentManager fm;
    private final int SY=0,FL=1,FX=2,GWC=3,WD=4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去掉标题栏、actionbar----沉浸式
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initview();
    }

    private void initview() {
        TextView main_shouye = findViewById(R.id.main_shouye);
        TextView main_fenlei = findViewById(R.id.main_fenlei);
        TextView main_faxian = findViewById(R.id.main_faxian);
        TextView main_gwc =findViewById(R.id.main_gwc);
        TextView main_wd = findViewById(R.id.main_wd);
        //将textvview添加到集合里面
        tv_list.add(main_shouye);
        tv_list.add(main_fenlei);
        tv_list.add(main_faxian);
        tv_list.add(main_gwc);
        tv_list.add(main_wd);

        main_shouye.setOnClickListener(this);
        main_fenlei.setOnClickListener(this);
        main_faxian.setOnClickListener(this);
        main_gwc.setOnClickListener(this);
        main_wd.setOnClickListener(this);
        //默认选中首页
        main_shouye.setSelected(true);
        //管理者
        fm = getSupportFragmentManager();
        //开启事务
        FragmentTransaction ft = fm.beginTransaction();
        for (int i = 0; i < 5; i++) {
            BaseFragment fragment = FragmentFactory.createFragment(i);
            ft.add(R.id.main_content, fragment);
            ft.hide(fragment);
            list.add(fragment);
        }
        ft.show(list.get(0));
        ft.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_shouye:
                //改变状态
                changeNav(SY);
                //联动
                changeFragment(SY);
                break;
            case R.id.main_fenlei:
                changeNav(FL);
                changeFragment(FL);
                break;
            case R.id.main_faxian:
                changeNav(FX);
                changeFragment(FX);
                break;
            case R.id.main_gwc:
                changeNav(GWC);
                changeFragment(GWC);
                break;
            case R.id.main_wd:
                changeNav(WD);
                changeFragment(WD);
                break;
        }
    }
    //切换导航栏状态的方法
    public void changeNav(int i) {
        for (int j = 0; j < tv_list.size(); j++) {
            if (j == i) {
                tv_list.get(i).setSelected(true);
            } else {
                tv_list.get(j).setSelected(false);
            }
        }
    }
    //切换Fragment的方法
    public void changeFragment(int type) {
        FragmentTransaction ft = fm.beginTransaction();
        for (int i = 0; i < list.size(); i++) {
            BaseFragment fragment = list.get(i);
            if (i == type) {
                ft.show(fragment);
            } else {
                ft.hide(fragment);
            }
        }
        ft.commit();
    }
}
