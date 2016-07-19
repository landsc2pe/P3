package com.example.homin.p3.Main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homin.p3.Main.base.BaseAdapter;
import com.example.homin.p3.Main.base.BaseFragment;
import com.example.homin.p3.Main.design.DesignFragment;
import com.example.homin.p3.Main.base.Util.Event.ClickEvent.ClickEvent;
import com.example.homin.p3.Main.base.Util.Event.ClickEvent.ClickEventId;
import com.example.homin.p3.Main.base.Util.Event.EventBus;
import com.example.homin.p3.R;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HOMIN on 2016-07-07.
 */
public class MainFragment extends BaseFragment {

    private List<String> itemList;
    private RecyclerView mainFragment;
    private MainAdapter mainAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        mainFragment = (RecyclerView) view.findViewById(R.id.main_fragment);

        //EventBus Register
        EventBus.getInstance().getBus().register(this);

        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
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
        itemList.add("Design Support Library");
        itemList.add("Expandable List View");
        itemList.add("Test3");
        itemList.add("Test4");
        itemList.add("Test5");
        itemList.add("Test6");
        itemList.add("Test7");
        itemList.add("Test8");


    }

    private void setFragment() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        mainAdapter = new MainAdapter(itemList);

        mainFragment.hasFixedSize();
        mainFragment.setLayoutManager(linearLayoutManager);
        mainFragment.setAdapter(mainAdapter);
    }

    private void setClickListener() {
        mainAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                switch (position) {
                    case 0:
                        itemTouchList(new ClickEvent(ClickEventId.ITEM_LIST_ONE));
//                        EventBus.getInstance().getBus().post(new ClickEvent(ClickEventId.ITEM_LIST_ONE));
                        break;
                    case 1:
                        itemTouchList(new ClickEvent(ClickEventId.ITEM_LIST_TWO));
//                        EventBus.getInstance().getBus().post(new ClickEvent(ClickEventId.ITEM_LIST_TWO));
                        break;
                    default:
                        Snackbar.make(getView(), "It`s not ready yet...", Snackbar.LENGTH_SHORT).show();
                        break;

                }
            }
        });

    }

    @Subscribe
    public void itemTouchList(ClickEvent event) {
        if (event.getId() == ClickEventId.ITEM_LIST_ONE) {
            Fragment designFragment = DesignFragment.newInstance();
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.main_layout, designFragment, "DesignFragment");
            fragmentTransaction.addToBackStack("DesignFragment");
            fragmentTransaction.commit();


        }
        if (event.getId() == ClickEventId.ITEM_LIST_TWO) {


        }


    }

}
