package com.example.lebed.zenvo.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.lebed.zenvo.R;

public class CustomerMainFilterActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_main_filter);
        init();
    }

    private void init(){
        ImageButton buttonBack = findViewById(R.id.customer_main_filter_back_button);
        buttonBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.customer_main_filter_back_button:
                finish();
        }
    }
}
