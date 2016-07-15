package com.example.homin.p3.Main.DesignSupportLIbrary;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homin.p3.Main.Base.BaseAdapter;
import com.example.homin.p3.Main.Base.BaseFragment;
import com.example.homin.p3.Main.Base.Util.Event.ClickEvent.ClickEvent;
import com.example.homin.p3.Main.Base.Util.Event.ClickEvent.ClickEventId;
import com.example.homin.p3.Main.Base.Util.Event.EventBus;
import com.example.homin.p3.Main.Base.Util.LogTag;
import com.example.homin.p3.R;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HOMIN on 2016-07-15.
 */
public class DesignFragment extends BaseFragment {

    private List<String> itemList;
    private DesignAdapter designAdapter;
    private RecyclerView designFragment;

    public static DesignFragment newInstance() {
        Bundle args = new Bundle();
        DesignFragment designFragment = new DesignFragment();
        designFragment.setArguments(args);

        return designFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.design_fragment, container, false);
        designFragment = (RecyclerView) view.findViewById(R.id.design_list);

        //EventBus Register
        EventBus.getInstance().getBus().register(this);

        return view;


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();
    }

    private void init() {
        makeItemList();
        setFragment();
        setClickListener();

    }

    private void makeItemList() {
        itemList = new ArrayList<>();
        itemList.add("Collapsing Layout");
        itemList.add("Floating Button");
        itemList.add("Test3");
        itemList.add("Test4");
        itemList.add("Test5");



    }

    @TargetApi(Build.VERSION_CODES.M)
    private void setFragment() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        designAdapter = new DesignAdapter(itemList);

        designFragment.hasFixedSize();
        designFragment.setLayoutManager(linearLayoutManager);
        designFragment.setAdapter(designAdapter);
    }

    private void setClickListener() {
        designAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                switch (position) {
                    case 0:
                        EventBus.getInstance().getBus().post(new ClickEvent(ClickEventId.DESIGN_LIST_ONE));
                        break;
                    case 1:
                        EventBus.getInstance().getBus().post(new ClickEvent(ClickEventId.DESIGN_LIST_TWO));
                        break;

                }
            }
        });

    }

    @Subscribe
    public void itemTouchList(ClickEvent event) {
        if (event.getId() == ClickEventId.DESIGN_LIST_ONE) {
            if(LogTag.DEBUG) Log.d(TAG, "Clicked 1 ");
            DesignFragmentCollapsingToolBar designFragmentCollapsingToolBar = DesignFragmentCollapsingToolBar.newInstance();
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.main_layout, designFragmentCollapsingToolBar, "FloatingFragment");
            fragmentTransaction.addToBackStack("FloatingFragment");
            fragmentTransaction.commit();
        }

        if (event.getId() == ClickEventId.DESIGN_LIST_TWO) {
            if(LogTag.DEBUG) Log.d(TAG, "Clicked 2 ");
            DesignFragmentFloatingButton designFragmentFloatingButton = DesignFragmentFloatingButton.newInstance();
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.main_layout, designFragmentFloatingButton, "FloatingFragment");
            fragmentTransaction.addToBackStack("FloatingFragment");
            fragmentTransaction.commit();
        }

    }
}
