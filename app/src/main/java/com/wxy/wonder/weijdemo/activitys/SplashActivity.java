package com.wxy.wonder.weijdemo.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.wxy.wonder.weijdemo.R;

import java.util.Timer;

public class SplashActivity extends Activity {

    private TextView splash_time;
    private int time = 3;
    private Timer timer;
    private MyHandler myHandler=new MyHandler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去掉标题栏、actionbar----沉浸式
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        initViews();
    }
    protected void initViews() {
        splash_time = findViewById(R.id.splash_time);
        ImageView spalsh_icon = findViewById(R.id.splash_pic);
        myHandler.sendEmptyMessage(0);
    }
    class MyHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            splash_time.setText(time+"s");
            time--;
            myHandler.sendEmptyMessageDelayed(0,1000);
            if(time==0){
                myHandler.removeCallbacksAndMessages(null);
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                //添加过渡动画
                overridePendingTransition(R.anim.enter_anim,R.anim.out_anim);
            }

        }
    }
}
