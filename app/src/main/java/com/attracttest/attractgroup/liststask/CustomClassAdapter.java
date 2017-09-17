package com.attracttest.attractgroup.liststask;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by nexus on 17.09.2017.
 */
public class CustomClassAdapter extends ArrayAdapter<CustomClass> {
    private LayoutInflater mInflater;
    private List<CustomClass> items;

    public CustomClassAdapter(Context context, List<CustomClass> objects, Fragment fragmentContext) {
        super(context, 0, objects);
        items = objects;
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public CustomClass getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // A ViewHolder keeps references to children views to avoid unneccessary calls
        // to findViewById() on each row.
        ViewHolder holder;


        // When convertView is not null, we can reuse it directly, there is no need
        // to reinflate it. We only inflate a new View when the convertView supplied
        // by ListView is null.
        if (view == null) {
            view = mInflater.inflate(R.layout.custom_item, null);

            // Creates a ViewHolder and store references to the two children views
            // we want to bind data to.
            holder = new ViewHolder();
            holder.text1 =  view.findViewById(R.id.first_row);
            holder.text2 =  view.findViewById(R.id.second_row);
            holder.text3 =  view.findViewById(R.id.third_row);

            view.setTag(holder);
        } else {

            // Get the ViewHolder back to get fast access to the TextView
            holder = (ViewHolder) view.getTag();
        }

        // Bind the data efficiently with the holder.
        holder.text1.setText(items.get(i).getField1());
        holder.text2.setText(items.get(i).getField2());
        holder.text3.setText(items.get(i).getField3());

        return view;
    }

    static class ViewHolder{
        TextView text1;
        TextView text2;
        TextView text3;
    }
}
