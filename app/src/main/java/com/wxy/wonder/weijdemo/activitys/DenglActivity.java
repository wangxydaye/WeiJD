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
import com.wxy.wonder.weijdemo.view.dengl.DenglView;

public class DenglActivity extends Activity implements DenglView,View.OnClickListener{
    private EditText name;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dengl);
        initview();
    }

    private void initview() {
        name= findViewById(R.id.name);
        password = findViewById(R.id.password);
        Button login=findViewById(R.id.login);
        Button zhuc=findViewById(R.id.zhuc);
        login.setOnClickListener(this);
        zhuc.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.login:
                DenglPresenterImpl loginPresenter = new DenglPresenterImpl();
                loginPresenter.loginPresenter(new DenglModelImpl(),this);
                break;
            case R.id.zhuc:
                Intent intent = new Intent(DenglActivity.this, ZhucActivity.class);
                startActivity(intent);
                break;
        }
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
    public void loginSuccess() {
        Intent intent = new Intent(DenglActivity.this, SplashActivity.class);
        startActivity(intent);
    }

    @Override
    public void loginError() {
        Toast.makeText(DenglActivity.this,"登录失败，请注册",Toast.LENGTH_LONG).show();
    }
}
