package com.wxy.wonder.weijdemo.fragments;

public class FragmentFactory {
    public static BaseFragment createFragment(int type) {
        BaseFragment fragment = null;
        switch (type) {
            case 0:
                fragment = new ShouYeFragment();
                break;
            case 1:
                fragment = new FenLeiFragment();
                break;
            case 2:
                fragment = new FaxianFragment();
                break;
            case 3:
                fragment = new GouWuCheFragment();
                break;
            case 4:
                fragment = new WdFragment();
                break;
        }
        return fragment;
    }
}
