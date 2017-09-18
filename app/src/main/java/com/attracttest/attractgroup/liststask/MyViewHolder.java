package com.attracttest.attractgroup.liststask;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by nexus on 17.09.2017.
 */
public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView text1;
    private TextView text2;
    private TextView text3;
    private CustomClass current;
    private int position;
    private Context context;

    public MyViewHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;
        itemView.setOnClickListener(this);
        text1 = (TextView) itemView.findViewById(R.id.first_row);
        text2 = (TextView) itemView.findViewById(R.id.second_row);
        text3 = (TextView) itemView.findViewById(R.id.third_row);
    }

    public void setData(CustomClass current, int position) {
        this.text1.setText(current.getField1());
        this.text2.setText(current.getField2());
        this.text3.setText(current.getField3());
        this.position = position;
        this.current = current;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(context, "Here comes the toast!", Toast.LENGTH_LONG).show();
    }

}
