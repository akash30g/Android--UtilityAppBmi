package com.example.bmiCal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Chart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chart);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            TextView txtResult = (TextView) findViewById(R.id.txt_result_bmi2);
            txtResult.setText(extras.getString("bmiResult"));
            TextView txtResultCat = (TextView) findViewById(R.id.txt_result_cat2);
            txtResultCat.setText(extras.getString("bmiCat"));
        }
    }

}
