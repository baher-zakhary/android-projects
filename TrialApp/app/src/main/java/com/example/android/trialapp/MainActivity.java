package com.example.android.trialapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        TextView myView = new TextView(this);
//        myView.setText("myView Text view");
//        myView.setTextSize(20);
//        myView.setBackgroundColor(Color.RED);
        setContentView(R.layout.activity_main);
    }
}
