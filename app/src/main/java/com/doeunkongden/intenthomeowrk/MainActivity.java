package com.doeunkongden.intenthomeowrk;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btn, btnDate;
    Spinner spinner;
    int mYear, mMonth, mDay;
    RadioGroup radioGroup;
    RadioButton radioButton;

    //Declaring variable for storing radio button value
    String gender;
    String name;
    String get_Date;
    String spinner_Value;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing view
        editText = findViewById(R.id.input_name);
        btn = findViewById(R.id.buttonSubmit);
        spinner = findViewById(R.id.spinner_list);
        btnDate = findViewById(R.id.btn_date);

        //initialize list for spinner
        List<String> City = new ArrayList<>();
        City.add("Phnom Penh");
        City.add("Sihanouk Ville");
        City.add("Kdal LA");
        City.add("Keab");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                City
        );

        //Set array list adapter to spinner list
        //Spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinner_Value = adapterView.getItemAtPosition(i).toString();
                Log.d("position", "onItemClick: " + adapterView.getItemAtPosition(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        //Button set for date (setOnClickListener)
        btnDate.setOnClickListener(view -> {
            Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int Year, int Month, int Day) {
                    get_Date = Year + "/" + Month + "/" + Day;
                    Log.d("Date get value", "onDateSet: " + get_Date);
                }
            }, mYear, mMonth, mDay);
            datePickerDialog.show();
        });


        //RadioGroup and Radio Button initialization
        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                radioButton = findViewById(i);
                gender = radioButton.getText().toString();
                Log.d("Radio button clicked", "onCheckedChanged: " + gender);
            }
        });


        //Button submit
        btn.setOnClickListener(view -> {
            //getting value from edit text
            name = editText.getText().toString();

            //information class
            Information information = new Information(name,get_Date,gender,spinner_Value);

            //sending value to secondActivity
            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            intent.putExtra("info",information);
            startActivity(intent);

        });


    }
}