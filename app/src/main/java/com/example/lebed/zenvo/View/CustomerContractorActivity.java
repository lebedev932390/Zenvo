package com.example.lebed.zenvo.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.lebed.zenvo.R;

public class CustomerContractorActivity extends AppCompatActivity implements View.OnClickListener {

    private String name;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_contractor);
        init();



    }

    private void init(){
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        ImageButton buttonBack = findViewById(R.id.customer_contractor_back_button);
        buttonBack.setOnClickListener(this);
        textView = findViewById(R.id.cutomer_contractor_activity_name);
        textView.setText(name);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.customer_contractor_back_button:
                finish();
        }
    }
}
