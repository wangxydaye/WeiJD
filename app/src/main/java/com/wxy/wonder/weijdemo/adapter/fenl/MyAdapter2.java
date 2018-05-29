package com.wxy.wonder.weijdemo.adapter.fenl;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;


import com.wxy.wonder.weijdemo.R;
import com.wxy.wonder.weijdemo.activitys.LiebActivity;
import com.wxy.wonder.weijdemo.bean.fenl.RightBean;

import java.util.List;

/**
 * Created by wonder on 2018/4/29.
 */

public class MyAdapter2 extends BaseAdapter {
    private static final String TAG = "MyAdapter2";
    private Context context;
    private List<RightBean.DataBean> list;
    public MyAdapter2(Context context, List<RightBean.DataBean> list){
        this.context=context;
        this.list=list;
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
        MyViewHolder2 myViewHolder2=null;
        if (view==null){
            view= View.inflate(context, R.layout.layout_right,null);
            TextView right_title = view.findViewById(R.id.right_title);
            GridView right_gv = view.findViewById(R.id.right_gv);
            myViewHolder2= new MyViewHolder2(right_title,right_gv);
            view.setTag(myViewHolder2);
        }
        else {
            myViewHolder2= (MyViewHolder2) view.getTag();
        }
        //赋值
        myViewHolder2.getRight_tv().setText(list.get(i).getName());
        List<RightBean.DataBean.ListBean> list1 = list.get(i).getList();
        Log.d(TAG, "getView: "+list1+"----"+list);
        MyAdapter3 myAdapter3 = new MyAdapter3(context, list1);
        myViewHolder2.getRight_gv().setAdapter(myAdapter3);
        myViewHolder2.getRight_gv().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(context,"Postiion"+i, Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(context, LiebActivity.class);
                context.startActivity(intent);
            }
        });
        return view;
    }
    class MyViewHolder2{
        private TextView right_tv;
        private GridView right_gv;

        public MyViewHolder2(TextView right_tv, GridView right_gv) {
            this.right_tv = right_tv;
            this.right_gv = right_gv;
        }

        public TextView getRight_tv() {
            return right_tv;
        }

        public void setRight_tv(TextView right_tv) {
            this.right_tv = right_tv;
        }

        public GridView getRight_gv() {
            return right_gv;
        }

        public void setRight_gv(GridView right_gv) {
            this.right_gv = right_gv;
        }
    }
}
