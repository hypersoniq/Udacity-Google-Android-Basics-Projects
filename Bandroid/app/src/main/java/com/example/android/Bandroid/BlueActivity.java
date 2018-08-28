package com.example.android.Bandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class BlueActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        // Create a list of imaginary songs
        final ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("The Blue Album", "Twenty One Pallets", "Warehouses", R.drawable.blue_album));
        songs.add(new Song("The Blue Album", "Twenty One Pallets", "Break Time", R.drawable.blue_album));
        songs.add(new Song("The Blue Album", "Twenty One Pallets", "Forklifts in Motion", R.drawable.blue_album));
        songs.add(new Song("The Blue Album", "Twenty One Pallets", "One Trailer at a time", R.drawable.blue_album));
        songs.add(new Song("The Blue Album", "Twenty One Pallets", "Logistic Mystic", R.drawable.blue_album));
        songs.add(new Song("The Blue Album", "Twenty One Pallets", "Product Damage", R.drawable.blue_album));
        songs.add(new Song("The Blue Album", "Twenty One Pallets", "What Raise?", R.drawable.blue_album));
        songs.add(new Song("The Blue Album", "Twenty One Pallets", "You're not worth the trip to Human Resources", R.drawable.blue_album));
        songs.add(new Song("The Blue Album", "Twenty One Pallets", "Sunrise, Work, Sunset (repeat)", R.drawable.blue_album));
        songs.add(new Song("The Blue Album", "Twenty One Pallets", "Sunset, Work, Sunrise (repeat) Third Shift ReMix", R.drawable.blue_album));

        // Create an {@link SongAdapter}, whose data source is a list of {@link Song}s. The
        // adapter knows how to create list items for each item in the list.
        SongAdapter adapter = new SongAdapter(this, songs, R.color.category_blue);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // song_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link SongAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Song} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to open the Now Playing activity when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //Get the {@link Song} object at the given position the user clicked on
                Song songNow = songs.get(position);
                //Open the Now Playing class via an intent
                Intent playIntent = new Intent(BlueActivity.this, com.example.android.Bandroid.NowPlayingActivity.class);
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