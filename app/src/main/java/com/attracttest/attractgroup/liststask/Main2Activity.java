package com.attracttest.attractgroup.liststask;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private Toolbar toolbar;
    private Fragment fragment2;
    private Bundle data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("staty", "Activity 2 onCreate()");
        setContentView(R.layout.activity_main2);
        if (getIntent().hasExtra("extra")){
            ArrayList<CustomClass> wow = (ArrayList<CustomClass>) getIntent().getSerializableExtra("extra");
            data = new Bundle();
            data.putSerializable("extra", wow);
            Log.e("staty", String.valueOf(wow.size()));
        }

        // Set a Toolbar to replace the ActionBar.
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Second");

        //Set fragment
        fragment2 = new Fragment2();
        fragment2.setArguments(data);

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.flContent2, fragment2).commit();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("staty", "Activity 2 onDestroy()");
    }
}
