package com.example.lebed.zenvo.View;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lebed.zenvo.R;
import com.example.lebed.zenvo.View.CustomerFragments.NonScrollableListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class CustomerMainFilterActivity extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    private ArrayList<String> selectedSort = new ArrayList<>();
    private NonScrollableListView listViewSort;
    private String[] sort = {"По возрастанию рейтинга","По убыванию рейтинга", "По возрастанию цены", "По убыванию цены"};


    private ArrayList<String> selectedLocations = new ArrayList<>();
    private NonScrollableListView listViewLocation;
    private String[] locations = {"Минск", "Гродно", "Витебск", "Могилев"};

    private ArrayList<String> selectedEntertainment = new ArrayList<>();
    private NonScrollableListView listViewEntertainment;
    private String[] entertainment = {"Игры и активность", "Виртуальная реальность", "Квесты", "Лазертаг"};

    private ArrayList<String> selectedPhotographers = new ArrayList<>();
    private NonScrollableListView listViewPhotographers;
    private String[] photographers = {"Свадебный фотограф", "Фотосессия Лав стори", "Фотограф на корпоратив", "Фотосьемка выписки из роддома"};






    Long startDate = null;
    Long endDate = null;

    private TextView textViewStartDate, textViewEndDate;


    private CheckBox checkBoxSort, checkBoxLocation, checkBoxEntertainment, checkBoxPhotographers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_main_filter);
        init();
        initListViews();
    }

    private void initListViews(){

        checkBoxSort = findViewById(R.id.customer_filter_sort_checkbox);
        checkBoxSort.setOnClickListener(this);
        listViewSort = findViewById(R.id.sort_list);
        listViewSort.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        ArrayAdapter<String> sortAdapter = new ArrayAdapter<String>(this,R.layout.filter_item, R.id.txt_lan, sort);
        listViewSort.setAdapter(sortAdapter);
        listViewSort.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected = ((CheckedTextView)view).getText().toString();
                if (selectedLocations.contains(selected)){
                    selectedLocations.remove(selected);
                    listViewSort.setItemChecked(position,false);
                    Log.e("selectedTotal", Integer.toString(selectedLocations.size()));
                } else {
                    listViewSort.setItemChecked(position,true);
                    selectedLocations.add(selected);
                    Log.e("selectedTotal", Integer.toString(selectedLocations.size()));

                }
            }
        });



        checkBoxLocation = findViewById(R.id.customer_filter_locations_checkbox);
        checkBoxLocation.setOnClickListener(this);
        listViewLocation = findViewById(R.id.locations_list);
        listViewLocation.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        ArrayAdapter<String> locationsAdapter = new ArrayAdapter<String>(this,R.layout.filter_item, R.id.txt_lan, locations);
        listViewLocation.setAdapter(locationsAdapter);
        listViewLocation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected = ((CheckedTextView)view).getText().toString();
                if (selectedLocations.contains(selected)){
                    selectedLocations.remove(selected);
                    Log.e("selectedTotal", Integer.toString(selectedLocations.size()));
                } else {
                    selectedLocations.add(selected);
                    Log.e("selectedTotal", Integer.toString(selectedLocations.size()));

                }
            }
        });

        checkBoxPhotographers = findViewById(R.id.customer_filter_photographers_checkbox);
        checkBoxPhotographers.setOnClickListener(this);
        listViewPhotographers = findViewById(R.id.photographers_list);
        listViewPhotographers.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        ArrayAdapter<String> photographersAdapter = new ArrayAdapter<String>(this,R.layout.filter_item, R.id.txt_lan, photographers);
        listViewPhotographers.setAdapter(photographersAdapter);
        listViewPhotographers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected = ((CheckedTextView)view).getText().toString();
                if (selectedPhotographers.contains(selected)){
                    selectedPhotographers.remove(selected);
                    Log.e("selectedTotal", Integer.toString(selectedPhotographers.size()));
                } else {
                    selectedPhotographers.add(selected);
                    Log.e("selectedTotal", Integer.toString(selectedPhotographers.size()));

                }
            }
        });

        checkBoxEntertainment = findViewById(R.id.customer_filter_entertainment_checkbox);
        checkBoxEntertainment.setOnClickListener(this);
        listViewEntertainment = findViewById(R.id.entertainment_list);
        listViewEntertainment.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        ArrayAdapter<String> entertainmentAdapter = new ArrayAdapter<String>(this,R.layout.filter_item, R.id.txt_lan, entertainment);
        listViewEntertainment.setAdapter(entertainmentAdapter);
        listViewEntertainment.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected = ((CheckedTextView)view).getText().toString();
                if (selectedEntertainment.contains(selected)){
                    selectedPhotographers.remove(selected);
                    Log.e("selectedTotal", Integer.toString(selectedPhotographers.size()));
                } else {
                    selectedPhotographers.add(selected);
                    Log.e("selectedTotal", Integer.toString(selectedPhotographers.size()));

                }
            }
        });







    }

    private void init() {





        ImageButton buttonBack = findViewById(R.id.customer_main_filter_back_button);
        buttonBack.setOnClickListener(this);
        ImageButton buttonDone = findViewById(R.id.customer_main_filter_done_button);
        buttonDone.setOnClickListener(this);

        textViewStartDate = findViewById(R.id.customer_filter_start_date);
        textViewEndDate = findViewById(R.id.customer_filter_end_date);
        textViewStartDate.setOnClickListener(this);
        textViewEndDate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.customer_filter_sort_checkbox:
                if (checkBoxSort.isChecked()){
                    listViewSort.setVisibility(View.VISIBLE);
                }
                else {
                    listViewSort.setVisibility(View.GONE);
                }
                break;
            case R.id.customer_main_filter_back_button:
                finish();
                break;
            case R.id.customer_main_filter_done_button:
                finish();
                break;

            case R.id.customer_filter_start_date:
                showDatePicker(R.id.customer_filter_start_date);
                break;
            case R.id.customer_filter_end_date:
                showDatePicker(R.id.customer_filter_end_date);

                break;

            case R.id.customer_filter_locations_checkbox:
                if (checkBoxLocation.isChecked()){
                    listViewLocation.setVisibility(View.VISIBLE);
                }
                else {
                    listViewLocation.setVisibility(View.GONE);
                }
                break;
            case R.id.customer_filter_photographers_checkbox:
                if (checkBoxPhotographers.isChecked()){
                    listViewPhotographers.setVisibility(View.VISIBLE);
                }
                else {
                    listViewPhotographers.setVisibility(View.GONE);
                }
                break;

            case R.id.customer_filter_entertainment_checkbox:
                if (checkBoxEntertainment.isChecked()){
                    listViewEntertainment.setVisibility(View.VISIBLE);
                }
                else {
                    listViewEntertainment.setVisibility(View.GONE);
                }
                break;
        }
    }


    private void showDatePicker(int id) {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePicker = new DatePickerDialog(this, this, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));


        switch (id) {
            case R.id.customer_filter_start_date:
                datePicker.getDatePicker().setTag(R.id.customer_filter_start_date);


                datePicker.getDatePicker().setMinDate(calendar.getTimeInMillis());

                break;

            case R.id.customer_filter_end_date:
                datePicker.getDatePicker().setTag(R.id.customer_filter_end_date);

                if (startDate != null) {

                    datePicker.getDatePicker().setMinDate(startDate);
                } else {
                    datePicker.getDatePicker().setMinDate(calendar.getTimeInMillis());
                }
                break;
        }
        datePicker.setTitle(null);
        datePicker.show();


    }




    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        switch ((Integer) view.getTag()) {
            case R.id.customer_filter_start_date:
                textViewStartDate.setBackground(getResources().getDrawable(R.drawable.checkbox_left_checked));
                textViewStartDate.setTextColor(getResources().getColor(R.color.md_white_1000));
                textViewStartDate.setText(simpleDateFormat.format(calendar.getTime()));
                calendar.clear(Calendar.HOUR_OF_DAY);
                calendar.clear(Calendar.MINUTE);
                calendar.clear(Calendar.SECOND);
                calendar.clear(Calendar.MILLISECOND);
                startDate = calendar.getTime().getTime();

                if (!textViewEndDate.getText().equals("До")) {
                    if (startDate > endDate) {
                        endDate = null;
                        textViewEndDate.setText("До");
                        textViewEndDate.setTextColor(getResources().getColor(R.color.colorPrimary));
                        textViewEndDate.setBackground(getResources().getDrawable(R.drawable.checkbox_left_unchecked));
                    }
                }
                break;
            case R.id.customer_filter_end_date:
                textViewEndDate.setBackground(getResources().getDrawable(R.drawable.checkbox_right_checked));
                textViewEndDate.setTextColor(getResources().getColor(R.color.md_white_1000));

                textViewEndDate.setText(simpleDateFormat.format(calendar.getTime()));
                calendar.clear(Calendar.HOUR_OF_DAY);
                calendar.clear(Calendar.MINUTE);
                calendar.clear(Calendar.SECOND);
                calendar.clear(Calendar.MILLISECOND);
                endDate = calendar.getTimeInMillis();
                break;

        }


    }
}
