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
import android.widget.LinearLayout;
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
    private String[] sort = {"По убыванию рейтинга","По возрастанию рейтинга", "По убыванию цены", "По возрастанию цены"};


    private ArrayList<String> selectedLocations = new ArrayList<>();
    private NonScrollableListView listViewMinskRegionLocation;
    private String[] minskRegionLocations = {"Минск", "Еще один", "И еще один", "Ну и еще один"};

    private NonScrollableListView listViewGrondoRegionLocation;
    private String[] grodnoRegionLocations = {"Гродно", "Слоним", "Барановичи", "Зельва"};

    private ArrayList<String> selectedEntertainment = new ArrayList<>();
    private NonScrollableListView listViewEntertainment;
    private String[] entertainment = {"Игры и активность", "Виртуальная реальность", "Квесты", "Лазертаг"};

    private ArrayList<String> selectedPhotographers = new ArrayList<>();
    private NonScrollableListView listViewPhotographers;
    private String[] photographers = {"Свадебный фотограф", "Фотосессия Лав стори", "Фотограф на корпоратив", "Фотосьемка выписки из роддома"};





    Long startDate = null;
    Long endDate = null;

    private TextView textViewStartDate, textViewEndDate;


    private CheckBox checkBoxSort, checkBoxChoseLocation, checkBoxMinskRegion, checkBoxGrodnoRegion, checkBoxChoseContractor, checkBoxEntertainment, checkBoxPhotographers;
    private LinearLayout linearLayoutLocations, linearLayoutContractors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_main_filter);
        init();
        initListViews();
    }

    private void initListViews(){

        checkBoxChoseLocation = findViewById(R.id.customer_filter_chose_location_checkbox);
        checkBoxChoseLocation.setOnClickListener(this);
        linearLayoutLocations = findViewById(R.id.locations_layout);

        checkBoxChoseContractor = findViewById(R.id.customer_filter_chose_contractor_checkbox);
        checkBoxChoseContractor.setOnClickListener(this);
        linearLayoutContractors = findViewById(R.id.layout_contractors);


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
                if (selectedSort.contains(selected)){
                    selectedSort.remove(selected);
                    listViewSort.setItemChecked(position,false);
                    Log.e("selectedTotal", Integer.toString(selectedSort.size()));
                } else {
                    selectedSort.clear();
                    selectedSort.add(selected);
                    Log.e("selectedTotal", Integer.toString(selectedSort.size()));

                }
            }
        });



        checkBoxMinskRegion = findViewById(R.id.customer_filter_minsk_region_checkbox);
        checkBoxMinskRegion.setOnClickListener(this);
        listViewMinskRegionLocation = findViewById(R.id.minks_region_list);
        listViewMinskRegionLocation.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        ArrayAdapter<String> minskRegionAdapter = new ArrayAdapter<String>(this,R.layout.filter_item, R.id.txt_lan, minskRegionLocations);
        listViewMinskRegionLocation.setAdapter(minskRegionAdapter);
        listViewMinskRegionLocation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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

        checkBoxGrodnoRegion = findViewById(R.id.customer_filter_grodno_region_checkbox);
        checkBoxGrodnoRegion.setOnClickListener(this);
        listViewGrondoRegionLocation = findViewById(R.id.grondo_region_list);
        listViewGrondoRegionLocation.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        ArrayAdapter<String> grodnoRegionAdapter = new ArrayAdapter<String>(this,R.layout.filter_item, R.id.txt_lan, grodnoRegionLocations);
        listViewGrondoRegionLocation.setAdapter(grodnoRegionAdapter);
        listViewGrondoRegionLocation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
        listViewPhotographers.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
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
        listViewEntertainment.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        ArrayAdapter<String> entertainmentAdapter = new ArrayAdapter<String>(this,R.layout.filter_item, R.id.txt_lan, entertainment);
        listViewEntertainment.setAdapter(entertainmentAdapter);
        listViewEntertainment.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected = ((CheckedTextView)view).getText().toString();
                if (selectedEntertainment.contains(selected)){
                    selectedEntertainment.remove(selected);
                    Log.e("selectedTotal", Integer.toString(selectedEntertainment.size()));
                } else {
                    selectedPhotographers.add(selected);
                    Log.e("selectedTotal", Integer.toString(selectedEntertainment.size()));

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

            case R.id.customer_filter_minsk_region_checkbox:
                if (checkBoxMinskRegion.isChecked()){
                    listViewMinskRegionLocation.setVisibility(View.VISIBLE);
                }
                else {
                    listViewMinskRegionLocation.setVisibility(View.GONE);
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

            case R.id.customer_filter_chose_location_checkbox:
                if (checkBoxChoseLocation.isChecked()){
                    linearLayoutLocations.setVisibility(View.VISIBLE);
                }
                else {
                    linearLayoutLocations.setVisibility(View.GONE);
                }
                break;
            case R.id.customer_filter_grodno_region_checkbox:
                if (checkBoxGrodnoRegion.isChecked()){
                    listViewGrondoRegionLocation.setVisibility(View.VISIBLE);
                }
                else {
                    listViewGrondoRegionLocation.setVisibility(View.GONE);
                }
                break;

            case R.id.customer_filter_chose_contractor_checkbox:
                if (checkBoxChoseContractor.isChecked()){
                    linearLayoutContractors.setVisibility(View.VISIBLE);
                }
                else {
                    linearLayoutContractors.setVisibility(View.GONE);
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
