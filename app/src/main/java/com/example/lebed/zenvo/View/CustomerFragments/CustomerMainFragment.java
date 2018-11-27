package com.example.lebed.zenvo.View.CustomerFragments;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lebed.zenvo.View.CustomerMainFilterActivity;
import com.example.lebed.zenvo.R;
import com.example.lebed.zenvo.View.CustomerContractorActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class CustomerMainFragment extends Fragment implements View.OnClickListener {


    public CustomerMainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_customer_main, container, false);

        final FloatingActionButton filterButton = view.findViewById(R.id.customer_fragment_main_filter_button);
        filterButton.setOnClickListener(this);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ryan_gosling);
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        roundedBitmapDrawable.setCircular(true);


        RecyclerView recyclerView = view.findViewById(R.id.customer_main_fragment_recycler_view);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(getActivity())
        );
        recyclerView.setAdapter(new RecyclerViewAdapter());
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE)
                {
                    filterButton.show();
                }

                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                {
                    if (dy > 0 ||dy<0 && filterButton.isShown())
                    {
                        filterButton.hide();
                    }
                }
            }
        });
        return view;
    }



    private class RecyclerViewHoled extends RecyclerView.ViewHolder {
        private CardView cardView;
        private TextView textView;

        public RecyclerViewHoled(@NonNull View itemView) {

            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getActivity(), CustomerContractorActivity.class));
                }
            });
        }

        public RecyclerViewHoled(LayoutInflater inflater, ViewGroup container) {
            super(inflater.inflate(R.layout.customer_card_contractor_profile, container, false));
            cardView = itemView.findViewById(R.id.customer_card_container);
            textView = itemView.findViewById(R.id.card_text);
        }
    }

    private class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHoled> {



        @NonNull
        @Override
        public RecyclerViewHoled onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            return new RecyclerViewHoled(inflater, viewGroup);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerViewHoled recyclerViewHoled, int i) {

        }

        @Override
        public int getItemCount() {
            return 20;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //case R.id.ryan_gosling:
//
            //    startActivity(new Intent(getActivity(), CustomerContractorActivity.class));
            //    break;
            case R.id.customer_fragment_main_filter_button:
                startActivity(new Intent(getActivity(), CustomerMainFilterActivity.class));

                break;
        }
    }
}
