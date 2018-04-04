package com.example.android.cookies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Called when the cookie should be eaten.
     */
    public void eatCookie(View view) {
        TextView changeTextView = (TextView) findViewById(R.id.status_text_view);
        changeTextView.setText("I'm so full");
        ImageView changeImageView = (ImageView) findViewById(R.id.android_cookie_image_view);
        changeImageView.setImageResource(R.drawable.after_cookie);
        Button btn = (Button) findViewById(R.id.eat_cookie_btn);
        btn.setEnabled(false);
        btn.setText("YUM");
    }
}
