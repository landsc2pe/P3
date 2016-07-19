package com.example.homin.p3.Main.design;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homin.p3.Main.base.BaseFragment;
import com.example.homin.p3.R;

/**
 * Created by HOMIN on 2016-07-18.
 */
public class DesignFragmentTabLayout extends BaseFragment {
    private ViewPager viewPager;
    private TabLayout tabLayout;

    public static DesignFragmentTabLayout newInstance() {
        Bundle args = new Bundle();
        DesignFragmentTabLayout designFragmentTabLayout = new DesignFragmentTabLayout();
        designFragmentTabLayout.setArguments(args);

        return designFragmentTabLayout;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.design_fragment_tablayout, container, false);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        viewPager.setAdapter(new DesignFragmentPagerAdapter(getActivity().getSupportFragmentManager(), getContext()));

        tabLayout = (TabLayout) view.findViewById(R.id.sliding_tabs);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
