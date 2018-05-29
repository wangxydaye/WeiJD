package com.wxy.wonder.weijdemo.adapter.fenl;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wxy.wonder.weijdemo.R;
import com.wxy.wonder.weijdemo.activitys.XiangActivity;
import com.wxy.wonder.weijdemo.bean.LieBean;

import java.util.List;

public class LieAdapter extends RecyclerView.Adapter<LieAdapter.MyViewHolder>{
    private  Context context;
    private  List<LieBean.DataBean> list;
    public MyItemClickListener myItemClickListener;

    public LieAdapter(Context context, List<LieBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.layout_lie, null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String pic_url = list.get(position).getImages().split("\\|")[0];
        holder.getLie_pic().setImageURI(pic_url);
        holder.getLie_title().setText(list.get(position).getTitle());
        //这是条目点击事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, XiangActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView lie_pic;
        private TextView lie_title;
        public MyViewHolder(View itemView) {
            super(itemView);
            lie_pic = itemView.findViewById(R.id.lie_pic);
            lie_title = itemView.findViewById(R.id.lie_title);
        }

        public MyViewHolder(View itemView, SimpleDraweeView lie_pic, TextView lie_title) {
            super(itemView);
            this.lie_pic = lie_pic;
            this.lie_title = lie_title;
        }

        public SimpleDraweeView getLie_pic() {
            return lie_pic;
        }

        public void setLie_pic(SimpleDraweeView lie_pic) {
            this.lie_pic = lie_pic;
        }

        public TextView getLie_title() {
            return lie_title;
        }

        public void setLie_title(TextView lie_title) {
            this.lie_title = lie_title;
        }
    }
    //自己定义条目点击事件
    public interface MyItemClickListener{
        void onItemClick(View view,int postion);
    }

    public void setMyItemClickListener(MyItemClickListener myItemClickListener){
        this.myItemClickListener = myItemClickListener;
    }
}
