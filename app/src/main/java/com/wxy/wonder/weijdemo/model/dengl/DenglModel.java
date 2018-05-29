package com.wxy.wonder.weijdemo.model.dengl;

import java.util.Map;

public interface DenglModel {
    void login(String url, Map<String,String> parms, LoginListener loginListener);
    void Reg(String url, Map<String,String> parms, LoginListener loginListener);
}
