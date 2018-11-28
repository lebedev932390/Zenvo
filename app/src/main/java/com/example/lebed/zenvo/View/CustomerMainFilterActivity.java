package com.example.lebed.zenvo.View;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.provider.Settings;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.lebed.zenvo.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CustomerMainFilterActivity extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener {
    //private String[] listOfItems = {"Minsk", "Grondo", "Slinum"};
    //private boolean[] chechedItems;
    //private ArrayList<Integer> userItems = new ArrayList<>();
    private List userPhotographers = new ArrayList();
    private AlertDialog photographers;
    Long startDate = null;
    Long endDate = null;

    private TextView textViewStartDate, textViewEndDate;


    private CheckBox price, rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_main_filter);
        init();
    }

    private void init() {
        ImageButton buttonBack = findViewById(R.id.customer_main_filter_back_button);
        buttonBack.setOnClickListener(this);

        Button locationButton = findViewById(R.id.filter_location_button);
        locationButton.setOnClickListener(this);
        price = findViewById(R.id.customer_filer_price_checkbox);
        rating = findViewById(R.id.customer_filer_rating_checkbox);
        price.setOnClickListener(this);
        rating.setOnClickListener(this);
        textViewStartDate = findViewById(R.id.customer_filter_start_date);
        textViewEndDate = findViewById(R.id.customer_filter_end_date);
        textViewStartDate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.customer_main_filter_back_button:
                finish();
                break;
            case R.id.filter_location_button:
                break;
            case R.id.customer_filer_price_checkbox:
                sortBy(R.id.customer_filer_price_checkbox);
                break;
            case R.id.customer_filer_rating_checkbox:
                sortBy(R.id.customer_filer_rating_checkbox);
                break;
            case R.id.customer_filter_start_date:
                showDatePicker(R.id.customer_filter_start_date);
                break;
            case R.id.customer_filter_end_date:
                showDatePicker(R.id.customer_filter_end_date);

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
        datePicker.show();


    }

    private void sortBy(int id) {
        switch (id) {
            case R.id.customer_filer_price_checkbox:
                Log.e("id", "price");
                rating.setChecked(false);
                break;
            case R.id.customer_filer_rating_checkbox:
                Log.e("id", "rating");

                price.setChecked(false);

                break;

        }
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
                textViewEndDate.setOnClickListener(this);
                textViewStartDate.setText(simpleDateFormat.format(calendar.getTime()));
                startDate = calendar.getTime().getTime();
                break;
            case R.id.customer_filter_end_date:
                textViewEndDate.setBackground(getResources().getDrawable(R.drawable.checkbox_right_checked));
                textViewEndDate.setTextColor(getResources().getColor(R.color.md_white_1000));

                textViewEndDate.setText(simpleDateFormat.format(calendar.getTime()));
                endDate = calendar.getTimeInMillis();
                break;

        }


    }
}
