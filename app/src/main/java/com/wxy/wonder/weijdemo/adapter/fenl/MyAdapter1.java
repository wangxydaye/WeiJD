package com.wxy.wonder.weijdemo.adapter.fenl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.wxy.wonder.weijdemo.R;
import com.wxy.wonder.weijdemo.bean.fenl.LeftBean;

import java.util.List;

/**
 * Created by wonder on 2018/4/29.
 */

public class MyAdapter1 extends BaseAdapter {
    private Context context;
    private List<LeftBean.DataBean> list;

    public MyAdapter1(Context context, List<LeftBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyViewHolder myViewHolder=null;
        if (view==null){
            view= View.inflate(context, R.layout.layout_left,null);
            TextView textView = view.findViewById(R.id.left_item_tv);

            myViewHolder=new MyViewHolder(textView);
            view.setTag(myViewHolder);
        }
        else {
            myViewHolder= (MyViewHolder) view.getTag();
        }
        myViewHolder.getTextView().setText(list.get(i).getName());
        return view;
    }
    class MyViewHolder{
        private TextView textView;

        public MyViewHolder(TextView textView) {
            this.textView = textView;
        }

        public TextView getTextView() {
            return textView;
        }

        public void setTextView(TextView textView) {
            this.textView = textView;
        }
    }
}
