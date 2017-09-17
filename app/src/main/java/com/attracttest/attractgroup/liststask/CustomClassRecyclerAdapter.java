package com.attracttest.attractgroup.liststask;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nexus on 17.09.2017.
 */
public class CustomClassRecyclerAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<CustomClass> mData;
    private LayoutInflater mInflater;

    public CustomClassRecyclerAdapter(Context context, ArrayList<CustomClass> data) {
        this.mData = data;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.custom_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        CustomClass currentClass = mData.get(position);
        holder.setData(currentClass, position);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
