package com.example.bmiCal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private final static String PREF_IS_METRIC = "system_of_unit";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);}

        /**
         * Function that allows us to calculate
         * BMI.
         *
         * Note: The function is called when
         * user press the "Calculate BMI"
         * button.
         *
         */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
        }


    public void calcBMI(View view) {
            // Do something in response to button click
        TextView txtResult = (TextView) findViewById(R.id.txt_result_bmi);
        TextView txtResultCat = (TextView) findViewById(R.id.txt_result_cat);
        EditText txtWeight = (EditText) findViewById(R.id.editTextWeight);
        EditText txtHeight = (EditText) findViewById(R.id.editTextHeight);

            try{

                double weight = Double.parseDouble(txtWeight.getText().toString());
                double height = Double.parseDouble(txtHeight.getText().toString());
                double result = weight / Math.pow(height, 2);
                txtResult.setText(String.format("%.1f", result));
                txtResultCat.setText(getCategory(result));

            } catch (NumberFormatException e){
                Log.d("Fail", "Error: " + e);
            }

        }

