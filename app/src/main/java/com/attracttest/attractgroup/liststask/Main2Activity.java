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

    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nvDrawer;
    private Intent intent;
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

        // Find our drawer view
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        // Find our drawer view
        nvDrawer = (NavigationView) findViewById(R.id.nvView);
        // Setup drawer view
        setupDrawerContent(nvDrawer);

        //Set fragment
        fragment2 = new Fragment2();

        fragment2.setArguments(data);

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.flContent2, fragment2).commit();

    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    public void selectDrawerItem(MenuItem menuItem) {

        if (menuItem.getItemId() == R.id.nav_first_fragment) {
            intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        mDrawer.closeDrawers();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("staty", "Activity 2 onDestroy()");
    }
}
