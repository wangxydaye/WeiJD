package com.wxy.wonder.weijdemo.activitys;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.wxy.wonder.weijdemo.R;
import com.wxy.wonder.weijdemo.model.dengl.DenglModelImpl;
import com.wxy.wonder.weijdemo.presenter.dengl.DenglPresenterImpl;
import com.wxy.wonder.weijdemo.view.dengl.DenglView;

import java.util.Map;

public class JddlActivity extends Activity implements DenglView,View.OnClickListener{
    private EditText tel;
    private EditText pwd;
    private Button butt;
    private ImageView jddlWei;
    private ImageView jddlQq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jddl);
        tel = findViewById(R.id.tel);
        pwd = findViewById(R.id.pwd);
        butt =findViewById(R.id.butt);
        butt.setOnClickListener(new View.OnClickListener() {
            //            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
//            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                // butt.setBackgroundColor(Color.RED);
                //butt.setBackground(getDrawable(R.drawable.but_color));
                DenglPresenterImpl denglPresenter = new DenglPresenterImpl();
                DenglModelImpl denglModel = new DenglModelImpl();
                denglPresenter.loginPresenter(denglModel,JddlActivity.this);
            }
        });
        jddlWei = findViewById(R.id.jddl_wei);
        jddlQq = findViewById(R.id.jddl_qq);
        jddlQq.setOnClickListener(this);
        jddlWei.setOnClickListener(this);
        //动态获取权限 6.0
        if(Build.VERSION.SDK_INT>=23){
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.CALL_PHONE,Manifest.permission.READ_LOGS,Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.SET_DEBUG_APP,Manifest.permission.SYSTEM_ALERT_WINDOW,Manifest.permission.GET_ACCOUNTS,Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions(this,mPermissionList,123);
        }

    }

    @Override
    public String getMobile() {
        return tel.getText().toString();
    }

    @Override
    public String getPassWord() {
        return pwd.getText().toString();
    }

    @Override
    public void loginSuccess() {
        startActivity(new Intent(JddlActivity.this, GeRenActivity.class));
    }

    @Override
    public void loginError() {
        Toast.makeText(JddlActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
    }
    //QQ，新浪
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }



    //权限回调
    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {

    }

    UMAuthListener authListener = new UMAuthListener() {
        /**
         * @desc 授权开始的回调
         * @param platform 平台名称
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @desc 授权成功的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param data 用户资料返回
         */
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {

            Toast.makeText(JddlActivity.this, "成功了", Toast.LENGTH_LONG).show();
            Intent intent=new Intent(JddlActivity.this,GeRenActivity.class);
            startActivity(intent);

        }

        /**
         * @desc 授权失败的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {

            Toast.makeText(JddlActivity.this, "失败：" + t.getMessage(),                                     Toast.LENGTH_LONG).show();
        }

        /**
         * @desc 授权取消的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         */
        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(JddlActivity.this, "取消了", Toast.LENGTH_LONG).show();
        }
    };


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.jddl_qq:
                //点击启动登录
                UMShareAPI.get(JddlActivity.this).getPlatformInfo(JddlActivity.this, SHARE_MEDIA.QQ, authListener);
                break;
            case R.id.jddl_wei:
                //点击启动登录
                UMShareAPI.get(JddlActivity.this).getPlatformInfo(JddlActivity.this, SHARE_MEDIA.WEIXIN, authListener);
                break;
        }
    }
}
