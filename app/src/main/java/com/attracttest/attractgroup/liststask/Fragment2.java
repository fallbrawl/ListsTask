package com.attracttest.attractgroup.liststask;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nexus on 17.09.2017.
 */
public class Fragment2 extends Fragment {
    private ArrayList<CustomClass> data;
    private CustomClassRecyclerAdapter adapter;
    private RecyclerView recyclerView;
    private boolean argumentsRead;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("staty", "Fragment 2 onCreate()");

        if (getArguments() != null && !argumentsRead) {
            Bundle extras = getArguments();
            data = (ArrayList<CustomClass>) extras.getSerializable("extra");
            Log.e("fragstaty", String.valueOf(data.size()));
            argumentsRead = true;

            // Create the adapter to convert the array to views
        } else {
            data = new ArrayList<>();
            data.add(new CustomClass("nothing", "cool", "here"));
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.custom_items_recycle_list, null);
        recyclerView = view.findViewById(R.id.recycler_view);
        adapter = new CustomClassRecyclerAdapter(getContext(), data);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e("staty", "Fragment 2 onDestroyView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("staty", "Fragment 2 onDestroy()");
    }
}
