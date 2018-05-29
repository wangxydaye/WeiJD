package com.wxy.wonder.weijdemo.model.fenl;

import java.util.Map;

/**
 * Created by wonder on 2018/4/29.
 */

public interface FenlModel {
    //获取左侧列表数据
    void getLeftList(String url, Map<String, String> map, GetLeftListener getLeftListener);
    //获右侧列表数据
    void getRightList(String url, Map<String, String> map, GetRightListener getRightListener);
}
