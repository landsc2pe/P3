package com.example.homin.p3.Main;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.homin.p3.Main.concurrent.TestRaceCondition;
import com.example.homin.p3.R;

public class MainActivity extends AppCompatActivity {

    private MainFragment mainFragment;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        init();
//        test();
    }

    private void init() {
        makeFragment();

    }

    private void makeFragment() {
        mainFragment = new MainFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_layout, mainFragment, "MainFragment");
        fragmentTransaction.commit();

    }

    void test() {
        TestRaceCondition.test();
    }
}
