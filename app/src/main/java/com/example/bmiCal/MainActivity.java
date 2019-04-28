package com.example.bmiCal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.EditorInfo;
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
    private boolean flag = false;
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
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.settings) {
            Intent i = new Intent(this, Settings.class);
            startActivity(i);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }

    }


    public void calcBMI(View view) {
            // Do something in response to button click
        TextView txtResult = (TextView) findViewById(R.id.txt_result_bmi);
        TextView txtResultCat = (TextView) findViewById(R.id.txt_result_cat);
        EditText txtWeight = (EditText) findViewById(R.id.editTextWeight);
        EditText txtHeight = (EditText) findViewById(R.id.editTextHeight);
        InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(txtResult.getWindowToken(), 0);

            try{

                double weight = Double.parseDouble(txtWeight.getText().toString());
                double height = Double.parseDouble(txtHeight.getText().toString());
                double result = weight / Math.pow(height, 2);
                txtResult.setText(String.format("Your BMI is: "+ "%.1f", result));
                txtResultCat.setText(getCategory(result));
                flag = true;

            } catch (NumberFormatException e){
                Log.d("Fail", "Error: " + e);
            }

        }
    private String getCategory(double bmi) {
        if (bmi < 15) {
            return getString(R.string.bmi_cat_1);
        }
        if (bmi < 16) {
            return getString(R.string.bmi_cat_2);
        }
        if (bmi < 18.5) {
            return getString(R.string.bmi_cat_3);
        }
        if (bmi < 25) {
            return getString(R.string.bmi_cat_4);
        }
        if (bmi < 30) {
            return getString(R.string.bmi_cat_5);
        }
        if (bmi < 35) {
            return getString(R.string.bmi_cat_6);
        }
        if (bmi < 40) {
            return getString(R.string.bmi_cat_7);
        }
        if (bmi < 45) {
            return getString(R.string.bmi_cat_8);
        }
        if (bmi < 50) {
            return getString(R.string.bmi_cat_9);
        }
        if (bmi < 60) {
            return getString(R.string.bmi_cat_10);
        }
        return getString(R.string.bmi_cat_11);
    }
    public void chart(View view) {
        if (flag) {
            TextView txtResult = (TextView) findViewById(R.id.txt_result_bmi);
            TextView txtResultCat = (TextView) findViewById(R.id.txt_result_cat);
            Intent intent = new Intent(this, Chart.class);
            intent.putExtra("bmiResult", txtResult.getText());
            intent.putExtra("bmiCat", txtResultCat.getText());
            startActivity(intent);
        } else {
            Log.d("BMI: ", "BMI not calculated.");
        }
    }

}
