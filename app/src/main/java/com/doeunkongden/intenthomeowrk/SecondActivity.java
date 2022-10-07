package com.doeunkongden.intenthomeowrk;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView txt;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //initialize View
        txt = findViewById(R.id.txt_result);

        Intent intent = getIntent();
        Information information =(Information) getIntent().getSerializableExtra("info");
        Log.d("resultText", "value from main is :  "+information.getName() + information.getDate() + information.getGender() + information.getCity());

        txt.setText("name:" + information.getName() + "/" + "DOB:" + information.getDate() + "/" + "Gender : " + information.getGender() + "/" + "City : " + information.getCity());


    }
}