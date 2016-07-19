package com.example.homin.p3.Main.design;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homin.p3.Main.base.BaseFragment;
import com.example.homin.p3.R;

/**
 * Created by HOMIN on 2016-07-17.
 */
public class DesignFragmentNavigation extends BaseFragment {


    public static DesignFragmentNavigation newInstance() {
        Bundle args = new Bundle();
        DesignFragmentNavigation designFragmentNavigation = new DesignFragmentNavigation();
        designFragmentNavigation.setArguments(args);

        return designFragmentNavigation;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.design_fragment_navigation, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();
    }

    private void init() {

    }

}
