package com.example.android.Bandroid;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.now_playing);

        // Get data passed from user click
        Intent input = getIntent();
        final String songTitleId= input.getStringExtra("curSong");
        final String artistId= input.getStringExtra("curArtist");
        final String albumId= input.getStringExtra("curAlbum");
        final int albumArtId= input.getIntExtra("curArt",1);

        // Make it a "song" object
        Song songForNow = new Song(albumId, artistId, songTitleId, albumArtId);


        // Populate the view with the data provided from the intent, but in the form
        // of a Song object.
        TextView songTitleTextView = (TextView) findViewById(R.id.song_text_view);
        songTitleTextView.setText(songForNow.getSongTitle());

        TextView artistTextView = (TextView) findViewById(R.id.artist_text_view);
        artistTextView.setText(songForNow.getArtist());

        TextView albumTextView = (TextView) findViewById(R.id.album_text_view);
        albumTextView.setText(songForNow.getAlbumTitle());

        ImageView imageView = (ImageView) findViewById(R.id.image);
        // Check if an image is provided for this song or not
        if (songForNow.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(songForNow.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        //Sets up the initial state of the play and pause images
        //Uses "GONE" instead of "INVISIBLE" to occupy the same space in the
        //layout
        final ImageView startImage = (ImageView) findViewById(R.id.play);
        final ImageView pauseImage = (ImageView) findViewById(R.id.pause);
        startImage.setVisibility(View.VISIBLE);
        pauseImage.setVisibility(View.GONE);

        // click listener to handle the logic for the "play" ImageView
        // hides the "play" image, shows the "pause" image
        // Displays toast message with "Now Playing " + song title.
        startImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startImage.setVisibility(View.GONE);
                pauseImage.setVisibility(View.VISIBLE);
                Toast.makeText(getApplicationContext(), ("Now Playing " + songTitleId), Toast.LENGTH_LONG).show();
            }
        });

        // click listener to handle the logic for the "pause" ImageView
        // hides the "pause" image, shows the "play" image
        // Displays toast message with song title + " Paused".
        pauseImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startImage.setVisibility(View.VISIBLE);
                pauseImage.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(), (songTitleId + " Paused"), Toast.LENGTH_LONG).show();
            }
        });
    }


}
