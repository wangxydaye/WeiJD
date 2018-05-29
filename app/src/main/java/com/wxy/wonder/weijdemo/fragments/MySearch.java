package com.wxy.wonder.weijdemo.fragments;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.wxy.wonder.weijdemo.R;

public class MySearch extends LinearLayout {
    private EditText et;
    public MySearch(Context context) {
        this(context,null);
    }

    public MySearch(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MySearch(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = View.inflate(context, R.layout.layout_search,this);
        et = view.findViewById(R.id.et);
        et.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                et.setFocusable(true);
            }
        });
    }
    //获取内容
    public String getContent(){
        return et.getText().toString();
    }
}
