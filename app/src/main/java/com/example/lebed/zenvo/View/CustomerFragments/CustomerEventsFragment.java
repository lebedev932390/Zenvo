package com.example.lebed.zenvo.View.CustomerFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lebed.zenvo.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class CustomerEventsFragment extends Fragment {


    public CustomerEventsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_customer_events, container, false);
    }

}
