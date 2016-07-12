package com.example.homin.p3.Main;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.homin.p3.R;

public class MainActivity extends AppCompatActivity {

    private MainFragment mainFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        init();
    }

    private void init() {
        makeFragment();

    }

    private void makeFragment() {
        mainFragment = new MainFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_activity, mainFragment);
        fragmentTransaction.commit();
    }

//    private void makeRecyclerView() {
//
//        RecyclerView mainView = new RecyclerView(this);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//
//        mainView.hasFixedSize();
//        mainView.setLayoutManager(layoutManager);
//            }



}
