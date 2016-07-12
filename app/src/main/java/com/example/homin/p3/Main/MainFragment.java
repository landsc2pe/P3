package com.example.homin.p3.Main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.homin.p3.Main.Util.Event.ClickEvent;
import com.example.homin.p3.Main.Util.Event.ClickEventId;
import com.example.homin.p3.Main.Util.EventBus;
import com.example.homin.p3.R;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HOMIN on 2016-07-07.
 */
public class MainFragment extends Fragment {

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


    @Override
    public void onDestroyView() {
        super.onDestroyView();

        //EventBus Unregister
        EventBus.getInstance().getBus().unregister(this);
    }



    private void init() {
        makeItemList();
        setFragment();
        setClickListener();
    }


    private void makeItemList() {
        itemList = new ArrayList<>();
        itemList.add("Test1");
        itemList.add("Test2");
        itemList.add("Test3");
        itemList.add("Test4");


    }

    private void setFragment() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        mainAdapter = new MainAdapter(itemList);

        mainFragment.hasFixedSize();
        mainFragment.setLayoutManager(linearLayoutManager);
        mainFragment.setAdapter(mainAdapter);
    }

    private void setClickListener() {
        mainAdapter.setOnItemClickListener(new MainAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                switch (position) {
                    case 0:
                        EventBus.getInstance().getBus().post(new ClickEvent(ClickEventId.ITEM_LIST_ONE));
                    case 1:
                        EventBus.getInstance().getBus().post(new ClickEvent(ClickEventId.ITEM_LIST_TWO));

                }
            }
        });

    }

    @Subscribe
    public void itemTouchList(ClickEvent event) {
        if (event.getId() == ClickEventId.ITEM_LIST_ONE) {
            Toast.makeText(getContext(), "Complete !!!", Toast.LENGTH_SHORT).show();
        }
        if (event.getId() == ClickEventId.ITEM_LIST_TWO) {

        }



    }

}
