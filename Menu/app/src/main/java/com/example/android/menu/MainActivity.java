package com.example.android.menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void printToLogs(View view) {
        // Find first menu item TextView and print the text to the logs
        TextView menuTextView1 = (TextView) findViewById(R.id.menu_item_1);
        String item1 = menuTextView1.getText().toString();
        Log.v("MyActivity", item1);
        // Find second menu item TextView and print the text to the logs
        TextView menuTextView2 = (TextView) findViewById(R.id.menu_item_2);
        String item2 = menuTextView2.getText().toString();
        Log.v("MyActivity", item2);
        // Find third menu item TextView and print the text to the logs
        TextView menuTextView3 = (TextView) findViewById(R.id.menu_item_3);
        String item3 = menuTextView3.getText().toString();
        Log.v("MyActivity", item3);
    }
}