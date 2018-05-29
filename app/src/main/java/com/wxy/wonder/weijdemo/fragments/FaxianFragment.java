package com.wxy.wonder.weijdemo.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.wxy.wonder.weijdemo.R;

public class FaxianFragment extends BaseFragment {
    private View view;
    private WebView webView;
    public static String url="https://h5.m.jd.com/active/faxian/list/article-list.html";
    @Override
    View createView(LayoutInflater inflater) {
        view = View.inflate(getActivity(),R.layout.layout_fx,null);
        webView = view.findViewById(R.id.web);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setLoadsImagesAutomatically(true); //支持自动加载图片
        settings.setDefaultTextEncodingName("utf-8");//设置编码格式
        webView.loadUrl(url);
        return view;
    }
}
