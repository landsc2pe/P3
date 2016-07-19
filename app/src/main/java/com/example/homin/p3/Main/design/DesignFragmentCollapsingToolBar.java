package com.example.homin.p3.Main.design;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homin.p3.Main.base.Util.LogTag;
import com.example.homin.p3.R;

/**
 * Created by HOMIN on 2016-07-15.
 */
public class DesignFragmentCollapsingToolBar extends Fragment {

    final String TAG = getClass().getSimpleName();

    private CollapsingToolbarLayout collapsingToolbar;

    public static DesignFragmentCollapsingToolBar newInstance() {
        Bundle args = new Bundle();
        DesignFragmentCollapsingToolBar designFragmentCollapsingToolBar = new DesignFragmentCollapsingToolBar();
        designFragmentCollapsingToolBar.setArguments(args);

        return designFragmentCollapsingToolBar;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.design_fragment_collapsing, container, false);
        collapsingToolbar = (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();
    }

    private void init() {
        setCollapsingToolBar();

    }

    // TODO: 2016-07-15 make sure how to change title size and text color.
    private void setCollapsingToolBar() {
        collapsingToolbar.setTitle("Collapsing Toolbar");
        collapsingToolbar.setExpandedTitleColor(getResources().getColor(R.color.colorAccent));
        collapsingToolbar.setCollapsedTitleTextColor(getResources().getColor(R.color.purpleColor));

        if(LogTag.DEBUG) Log.d(TAG, ""+getResources().getColor(R.color.colorAccent));
    }
}
