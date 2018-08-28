package com.example.android.Bandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class GreenActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);


        // Create a list of imaginary songs
        final ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("The Green Album", "Beau and the Hillbillies", "Kissin' Cousins", R.drawable.green_album));
        songs.add(new Song("The Green Album", "Beau and the Hillbillies", "Best Reunion Ever", R.drawable.green_album));
        songs.add(new Song("The Green Album", "Beau and the Hillbillies", "Beer by the Barrel", R.drawable.green_album));
        songs.add(new Song("The Green Album", "Beau and the Hillbillies", "Duck Blinds", R.drawable.green_album));
        songs.add(new Song("The Green Album", "Beau and the Hillbillies", "Outstanding in our Field", R.drawable.green_album));
        songs.add(new Song("The Green Album", "Beau and the Hillbillies", "The Fake McCoy", R.drawable.green_album));
        songs.add(new Song("The Green Album", "Beau and the Hillbillies", "Tell Me True", R.drawable.green_album));
        songs.add(new Song("The Green Album", "Beau and the Hillbillies", "Hey Mister, Hands off my Sister (I seen her first)", R.drawable.green_album));
        songs.add(new Song("The Green Album", "Beau and the Hillbillies", "Banjo Battle", R.drawable.green_album));
        songs.add(new Song("The Green Album", "Beau and the Hillbillies", "The ATV song", R.drawable.green_album));

        // Create an {@link SongAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        SongAdapter adapter = new SongAdapter(this, songs, R.color.category_green);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // song_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);


        // Set a click listener to open the Now Playing activity when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //Get the {@link Song} object at the given position the user clicked on
                Song songNow = songs.get(position);
                //Open the Now Playing class via an intent
                Intent playIntent = new Intent(GreenActivity.this, com.example.android.Bandroid.NowPlayingActivity.class);
                //Pass the Song information
                String currentArtist = songNow.getArtist();
                String currentAlbum = songNow.getAlbumTitle();
                String currentSong = songNow.getSongTitle();
                int currentAlbumCover = songNow.getImageResourceId();
                playIntent.putExtra("curSong", currentSong);
                playIntent.putExtra("curArtist", currentArtist);
                playIntent.putExtra("curAlbum", currentAlbum);
                playIntent.putExtra("curArt", currentAlbumCover);
                // Start the new activity
                startActivity(playIntent);
            }
        });
    }
}