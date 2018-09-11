package com.example.android.tourguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class EntertainmentFragment extends Fragment {

    public EntertainmentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        // Create a list of points of interest for this category
        final ArrayList<PointOfInterest> pointsOfInterest = new ArrayList<PointOfInterest>();
        pointsOfInterest.add(new PointOfInterest(R.string.entertainment_01, R.string.add_ent_01,
                R.string.pho_ent_01, R.string.web_ent_01, R.drawable.entertainment_001));
        pointsOfInterest.add(new PointOfInterest(R.string.entertainment_02, R.string.add_ent_02,
                R.string.pho_ent_02, R.string.web_ent_02, R.drawable.entertainment_002));
        pointsOfInterest.add(new PointOfInterest(R.string.entertainment_03, R.string.add_ent_03,
                R.string.pho_ent_03, R.string.web_ent_03, R.drawable.entertainment_003));
        pointsOfInterest.add(new PointOfInterest(R.string.entertainment_04, R.string.add_ent_04,
                R.string.pho_ent_04, R.string.web_ent_04, R.drawable.entertainment_004));
        pointsOfInterest.add(new PointOfInterest(R.string.entertainment_05, R.string.add_ent_05,
                R.string.pho_ent_05, R.string.web_ent_05, R.drawable.entertainment_005));
        pointsOfInterest.add(new PointOfInterest(R.string.entertainment_06, R.string.add_ent_06,
                R.string.pho_ent_06, R.string.web_ent_06, R.drawable.entertainment_006));
        pointsOfInterest.add(new PointOfInterest(R.string.entertainment_07, R.string.add_ent_07,
                R.string.pho_ent_07, R.string.web_ent_07, R.drawable.entertainment_007));
        pointsOfInterest.add(new PointOfInterest(R.string.entertainment_08, R.string.add_ent_08,
                R.string.pho_ent_08, R.string.web_ent_08, R.drawable.entertainment_008));

        // Create an {@link PointOfInterestAdapter}, whose data source is a list of {@link PointOfInterest}s. The
        // adapter knows how to create list items for each item in the list.
        PointOfInterestAdapter adapter = new PointOfInterestAdapter(getActivity(), pointsOfInterest, R.color.category_entertainment);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link PointOfInterestAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to open the Point Of Interest fragment when the list item is clicked on or swiped
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Get the {@link PointOfInterest} object at the given position the user clicked on
                PointOfInterest Poi = pointsOfInterest.get(position);
                //Open the Now Playing class via an intent
                Intent poiIntent = new Intent(getActivity(), com.example.android.tourguide.BusinessCardActivity.class);
                //Pass the Song information
                int currentName = Poi.getPointOfInterestName();
                int currentAddress = Poi.getPointOfInterestAddress();
                int currentPhone = Poi.getPointOfInterestPhone();
                int currentWebsite = Poi.getPointOfInterestWeb();
                int currentImage = Poi.getImageResourceId();
                poiIntent.putExtra("curName", currentName);
                poiIntent.putExtra("curAddress", currentAddress);
                poiIntent.putExtra("curPhone", currentPhone);
                poiIntent.putExtra("curWebsite", currentWebsite);
                poiIntent.putExtra("curImage", currentImage);
                // Start the new activity
                startActivity(poiIntent);
            }
        });

        return rootView;
    }

}
