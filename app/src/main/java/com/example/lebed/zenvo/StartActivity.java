package com.example.lebed.zenvo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lebed.zenvo.View.CustomerActivity;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        startActivity(new Intent(this, CustomerActivity.class));
        finish();
    }
}
