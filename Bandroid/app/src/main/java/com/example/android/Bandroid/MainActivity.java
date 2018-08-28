package com.example.android.Bandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Find the View that shows the orange album
        TextView orange = (TextView) findViewById(R.id.orange);

        // Set a click listener on that View
        orange.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link OrangeActivity}
                Intent orangeIntent = new Intent(MainActivity.this, com.example.android.Bandroid.OrangeActivity.class);

                // Start the new activity
                startActivity(orangeIntent);
            }
        });

        // Find the View that shows the green album
        TextView green = (TextView) findViewById(R.id.green);

        // Set a click listener on that View
        green.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the family category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link GreenActivity}
                Intent greenIntent = new Intent(MainActivity.this, com.example.android.Bandroid.GreenActivity.class);

                // Start the new activity
                startActivity(greenIntent);
            }
        });

        // Find the View that shows the purple album
        TextView purple = (TextView) findViewById(R.id.purple);

        // Set a click listener on that View
       purple.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the colors category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link ColorsActivity}
                Intent purpleIntent = new Intent(MainActivity.this, com.example.android.Bandroid.PurpleActivity.class);

                // Start the new activity
                startActivity(purpleIntent);
            }
        });

        // Find the View that shows the blue album
        TextView blue = (TextView) findViewById(R.id.blue);

        // Set a click listener on that View
        blue.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the phrases category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link PhrasesActivity}
                Intent blueIntent = new Intent(MainActivity.this, com.example.android.Bandroid.BlueActivity.class);

                // Start the new activity
                startActivity(blueIntent);
            }
        });
    }
}
