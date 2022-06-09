package com.bkacad.androiddemo2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;


import java.util.List;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private List<Food> foodList;
    private LayoutInflater inflater;

    public MyAdapter(Context context, List<Food> foodList) {
        this.context = context;
        this.foodList = foodList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return foodList.size();
    }

    @Override
    public Object getItem(int i) {
        return foodList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = inflater.inflate(R.layout.item_view, viewGroup, false);
        }
        // Bind id
        ImageView imgFood = view.findViewById(R.id.imgFood);
        TextView tvName = view.findViewById(R.id.tvFood);
        TextView tvPrice = view.findViewById(R.id.tvPrice);
        // Đổ dữ liệu từ data -> vào các item view
        Food itemFood = foodList.get(i);
        Glide.with(view).load(itemFood.imageURL).into(imgFood);
        tvName.setText(itemFood.name);
        tvPrice.setText(itemFood.price);
        return view;
    }
}
