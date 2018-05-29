package com.wxy.wonder.weijdemo.model.dengl;

public interface LoginListener {
    void loginSuccess(String json);
    void loginError(String error);
}
