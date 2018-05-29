package com.wxy.wonder.weijdemo.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wxy.wonder.weijdemo.R;
import com.wxy.wonder.weijdemo.model.dengl.DenglModelImpl;
import com.wxy.wonder.weijdemo.presenter.dengl.DenglPresenterImpl;
import com.wxy.wonder.weijdemo.view.dengl.ZhucView;

public class ZhucActivity extends Activity implements ZhucView,View.OnClickListener {
    private EditText name;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuc);
        //初始化
        initview();
    }

    private void initview() {
        name= findViewById(R.id.name);
        password = findViewById(R.id.password);
        Button zhuc=findViewById(R.id.zhuc);
        zhuc.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        DenglPresenterImpl loginPresenter = new DenglPresenterImpl();
        loginPresenter.RegPresenter(new DenglModelImpl(),this);
    }

    @Override
    public String getMobile() {
        return name.getText().toString();
    }

    @Override
    public String getPassWord() {
        return password.getText().toString();
    }

    @Override
    public void regSuccess() {
        Intent intent = new Intent(ZhucActivity.this, DenglActivity.class);
        startActivity(intent);
    }

    @Override
    public void regError() {
        Toast.makeText(ZhucActivity.this,"注册失败",Toast.LENGTH_LONG).show();
    }


}
