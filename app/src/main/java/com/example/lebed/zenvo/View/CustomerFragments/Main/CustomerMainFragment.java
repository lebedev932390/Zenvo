package com.example.lebed.zenvo.View.CustomerFragments.Main;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
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
import android.widget.Toast;

import com.example.lebed.zenvo.View.CustomerActivity;
import com.example.lebed.zenvo.View.CustomerMainFilterActivity;
import com.example.lebed.zenvo.R;
import com.example.lebed.zenvo.View.CustomerContractorActivity;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CustomerMainFragment extends Fragment implements View.OnClickListener {


    public CustomerMainFragment() {
        // Required empty public constructor
    }

    private List<CardContractor> contractorsList;
    private RecyclerView recyclerView;
    private CardContractorAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_customer_main, container, false);
        contractorsList = ((CustomerActivity)getActivity()).getListOfContractors();
        final FloatingActionButton filterButton = view.findViewById(R.id.customer_fragment_main_filter_button);
        filterButton.setOnClickListener(this);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ryan_gosling);
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        roundedBitmapDrawable.setCircular(true);


        recyclerView = view.findViewById(R.id.customer_main_fragment_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        adapter = new CardContractorAdapter(contractorsList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new CardContractorAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getActivity(),Integer.toString(position), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), CustomerContractorActivity.class);
                intent.putExtra("name", Integer.toString(position) + " - " + contractorsList.get(position).getName());
                startActivity(intent);
            }
        });
        recyclerView.setLayoutManager(
                new LinearLayoutManager(getActivity())
        );
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

    //private void init(){
    //    contractorsList = new ArrayList<>();
    //    contractorsList.add(new CardContractor(roundDrawable(R.drawable.mask),"Елон Маск", "4.7","Марс", "Отзывов: 32"));
    //    contractorsList.add(new CardContractor(roundDrawable(R.drawable.penelopa),"Пенелопа Крус", "4.1","Щучин", "Отзывов: 98"));
    //    contractorsList.add(new CardContractor(roundDrawable(R.drawable.peris),"Сергей Светлаков", "2.7","Светлогорск", "Отзывов: 8"));
    //    contractorsList.add(new CardContractor(roundDrawable(R.drawable.tea),"Золотая Чаша", "3.1","Кухонный шкафчик", "Отзывов: 41"));
    //    contractorsList.add(new CardContractor(roundDrawable(R.drawable.gosling),"Райан Гослинг", "4.9","Зельва", "Отзывов: 56"));
    //    contractorsList.add(new CardContractor(roundDrawable(R.drawable.mask),"Елон Маск", "4.7","Марс", "Отзывов: 32"));
    //    contractorsList.add(new CardContractor(roundDrawable(R.drawable.penelopa),"Пенелопа Крус", "4.1","Щучин", "Отзывов: 98"));
    //    contractorsList.add(new CardContractor(roundDrawable(R.drawable.peris),"Сергей Светлаков", "2.7","Светлогорск", "Отзывов: 8"));
    //    contractorsList.add(new CardContractor(roundDrawable(R.drawable.tea),"Золотая Чаша", "3.1","Кухонный шкафчик", "Отзывов: 41"));
    //    contractorsList.add(new CardContractor(roundDrawable(R.drawable.gosling),"Райан Гослинг", "4.9","Зельва", "Отзывов: 56"));
    //    contractorsList.add(new CardContractor(roundDrawable(R.drawable.mask),"Елон Маск", "4.7","Марс", "Отзывов: 32"));
    //    contractorsList.add(new CardContractor(roundDrawable(R.drawable.penelopa),"Пенелопа Крус", "4.1","Щучин", "Отзывов: 98"));
    //    contractorsList.add(new CardContractor(roundDrawable(R.drawable.peris),"Сергей Светлаков", "2.7","Светлогорск", "Отзывов: 8"));
    //    contractorsList.add(new CardContractor(roundDrawable(R.drawable.tea),"Золотая Чаша", "3.1","Кухонный шкафчик", "Отзывов: 41"));
    //    contractorsList.add(new CardContractor(roundDrawable(R.drawable.gosling),"Райан Гослинг", "4.9","Зельва", "Отзывов: 56"));
    //    contractorsList.add(new CardContractor(roundDrawable(R.drawable.mask),"Елон Маск", "4.7","Марс", "Отзывов: 32"));
    //    contractorsList.add(new CardContractor(roundDrawable(R.drawable.penelopa),"Пенелопа Крус", "4.1","Щучин", "Отзывов: 98"));
    //    contractorsList.add(new CardContractor(roundDrawable(R.drawable.peris),"Сергей Светлаков", "2.7","Светлогорск", "Отзывов: 8"));
    //    contractorsList.add(new CardContractor(roundDrawable(R.drawable.tea),"Золотая Чаша", "3.1","Кухонный шкафчик", "Отзывов: 41"));
    //    contractorsList.add(new CardContractor(roundDrawable(R.drawable.gosling),"Райан Гослинг", "4.9","Зельва", "Отзывов: 56"));
////
//
//
//
//
//
    //}







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
