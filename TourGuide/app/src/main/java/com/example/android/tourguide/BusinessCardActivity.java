package com.example.android.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class BusinessCardActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.point_of_interest);

        // Get data passed from user click
        Intent input = getIntent();
        final int name = input.getIntExtra("curName", 1);
        final int address = input.getIntExtra("curAddress", 1);
        final int phone = input.getIntExtra("curPhone", 1);
        final int website = input.getIntExtra("curWebsite", 1);
        final int image = input.getIntExtra("curImage", 1);

        // Make it a "PointOfInterest" object
        PointOfInterest rightHere = new PointOfInterest(name, address, phone, website, image);

        // Populate the view with the data provided from the intent, but in the form
        // of a PointOfInterest object.
        TextView nameTextView = (TextView) findViewById(R.id.name_line);
        nameTextView.setText(rightHere.getPointOfInterestName());

        TextView addressTextView = (TextView) findViewById(R.id.address_line);
        addressTextView.setText(rightHere.getPointOfInterestAddress());

        TextView phoneTextView = (TextView) findViewById(R.id.phone_line);
        phoneTextView.setText(rightHere.getPointOfInterestPhone());

        TextView webTextView = (TextView) findViewById(R.id.web_line);
        webTextView.setText(rightHere.getPointOfInterestWeb());

        ImageView imageView = (ImageView) findViewById(R.id.image);
        // Check if an image is provided for this song or not
        if (rightHere.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(rightHere.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // Navigation back to the calling fragment.
        findViewById(R.id.toList).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Go back to the album list that the song is from
                finish();
            }
        });
    }
}
