package com.wxy.wonder.weijdemo.presenter.shouy;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wxy.wonder.weijdemo.R;
import com.wxy.wonder.weijdemo.bean.shouy.Shouye_bean;

import java.util.List;

public class Mytuijian extends RecyclerView.Adapter<Mytuijian.Tuijianhodler> {
    private Context context;
    private List<Shouye_bean.TuijianBean.ListBean> list;

    public Mytuijian(Context context, List<Shouye_bean.TuijianBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public Tuijianhodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.shouye_tuijian_zi, null);
        Tuijianhodler tuijianhodler=new Tuijianhodler(view);
        return tuijianhodler;
    }

    @Override
    public void onBindViewHolder(Tuijianhodler holder, int position) {
        String images = list.get(position).getImages();
        String[] split = images.split(".jpg");
        holder.sd.setImageURI(split[0]+".jpg");
        holder.jiugongge_tv.setText(list.get(position).getPrice()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Tuijianhodler extends RecyclerView.ViewHolder{
        public SimpleDraweeView sd;
        public TextView jiugongge_tv;
        public Tuijianhodler(View itemView) {
            super(itemView);
            this.sd=itemView.findViewById(R.id.sd);
            this.jiugongge_tv=itemView.findViewById(R.id.jiugongge_tv);
        }
    }
}
