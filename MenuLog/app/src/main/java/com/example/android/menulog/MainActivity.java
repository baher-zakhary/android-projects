package com.example.android.menulog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.android.menulog.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void printToLogs(View view) {
        // Find first menu item TextView and print the text to the logs
        TextView t1 = (TextView) findViewById(R.id.menu_item_1);
        Log.i("MainActivity", t1.getText().toString());
        // Find second menu item TextView and print the text to the logs
        TextView t2 = (TextView) findViewById(R.id.menu_item_2);
        Log.i("MainActivity", t2.getText().toString());
        // Find third menu item TextView and print the text to the logs
        TextView t3 = (TextView) findViewById(R.id.menu_item_3);
        Log.i("MainActivity", t3.getText().toString());
    }
}