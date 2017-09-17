package com.attracttest.attractgroup.liststask;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

/**
 * Created by nexus on 17.09.2017.
 */
public class Fragment1 extends Fragment {
    private CustomClassAdapter adapter;
    private List<CustomClass> arrayOfUsers;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Construct the data source
        arrayOfUsers = CustomClass.init();
        // Create the adapter to convert the array to views
        adapter = new CustomClassAdapter(getContext(), arrayOfUsers, this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.custom_items_list, null);
        ListView listView = view.findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        return view;
    }

}
