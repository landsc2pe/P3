package com.example.homin.p3.Main.DesignSupportLIbrary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homin.p3.R;

/**
 * Created by HOMIN on 2016-07-14.
 */
public class DesignFragmentFloatingButton extends Fragment {

    final String TAG = DesignFragmentFloatingButton.class.getSimpleName();
    private FloatingActionButton fab;
    private TextInputLayout floatingUsernameLabel;
    private CollapsingToolbarLayout collapsingToolbar;
    private Toolbar toolbar;

    public static DesignFragmentFloatingButton newInstance() {
        Bundle args = new Bundle();
        DesignFragmentFloatingButton designFragmentFloatingButton = new DesignFragmentFloatingButton();
        designFragmentFloatingButton.setArguments(args);

        return designFragmentFloatingButton;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.design_fragment_floatingbutton, container, false);
        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        floatingUsernameLabel = (TextInputLayout) view.findViewById(R.id.username_text_input_layout);
//        collapsingToolbar = (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);

        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        init();


    }

    private void init() {
//      setToolbar();
        setFloatingActionButton();
    }

    private void setToolbar() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
//        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("Design Support Library");


    }


    private void setFloatingActionButton() {

        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Button Clicked !!!", Snackbar.LENGTH_LONG).show();

//                Snackbar.make(parentView, R.string.snackbar_text, Snackbar.LENGTH_LONG)
//                        .setAction(R.string.snackbar_action, myOnClickListener)  // action text on the right side
//                        .setActionTextColor(R.color.green)
//                        .setDuration(3000).show();
            }
        });
    }

    private void setupFloatingLabelError() {

//        floatingUsernameLabel.getEditText().addTextChangedListener(new TextWatcher() {
//            // ...
//            @Override
//            public void onTextChanged(CharSequence text, int start, int count, int after) {
//                if (text.length() > 0 && text.length() <= 4) {
//                    floatingUsernameLabel.setError(getString(R.string.username_required));
//                    floatingUsernameLabel.setErrorEnabled(true);
//                } else {
//                    floatingUsernameLabel.setErrorEnabled(false);
//                }
//            }
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count,
//                                          int after) {
//                // TODO Auto-generated method stub
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });
    }

}
