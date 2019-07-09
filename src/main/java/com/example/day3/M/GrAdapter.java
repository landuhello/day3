package com.example.day3.M;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.day3.R;

import java.util.List;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public class GrAdapter extends BaseAdapter {
    private List<SoBean.ResultBean> list;
    private Context context;
    private Viewholder holder;

    public GrAdapter(List<SoBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view==null){
            view=View.inflate(context, R.layout.item,null);
            holder = new Viewholder();
            holder.textView=view.findViewById(R.id.zi);
            holder.imageView=view.findViewById(R.id.tu);
            view.setTag(holder);
        }else {
            holder= (Viewholder) view.getTag();
        }
        holder.textView.setText(list.get(i).getCommodityName());
        Glide.with(context).load(list.get(i).getMasterPic()).into(holder.imageView);
        return view;
    }
    class Viewholder{
        TextView textView;
        ImageView imageView;
    }
}
