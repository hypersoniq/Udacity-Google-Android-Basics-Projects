package com.example.android.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * {@link Fragment} that displays a list of Myrtle Beach attractions.
 */
public class AttractionsFragment extends Fragment {

    public AttractionsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        // Create a list of points of interest for this category
        final ArrayList<PointOfInterest> pointsOfInterest = new ArrayList<PointOfInterest>();
        pointsOfInterest.add(new PointOfInterest(R.string.attractions_01, R.string.add_att_01,
                R.string.pho_att_01, R.string.web_att_01, R.drawable.attractions_001));
        pointsOfInterest.add(new PointOfInterest(R.string.attractions_02, R.string.add_att_02,
                R.string.pho_att_02, R.string.web_att_02, R.drawable.attractions_002));
        pointsOfInterest.add(new PointOfInterest(R.string.attractions_03, R.string.add_att_03,
                R.string.pho_att_03, R.string.web_att_03, R.drawable.attractions_003));
        pointsOfInterest.add(new PointOfInterest(R.string.attractions_04, R.string.add_att_04,
                R.string.pho_att_04, R.string.web_att_04, R.drawable.attractions_004));
        pointsOfInterest.add(new PointOfInterest(R.string.attractions_05, R.string.add_att_05,
                R.string.pho_att_05, R.string.web_att_05, R.drawable.attractions_005));
        pointsOfInterest.add(new PointOfInterest(R.string.attractions_06, R.string.add_att_06,
                R.string.pho_att_06, R.string.web_att_06, R.drawable.attractions_006));
        pointsOfInterest.add(new PointOfInterest(R.string.attractions_07, R.string.add_att_07,
                R.string.pho_att_07, R.string.web_att_07, R.drawable.attractions_007));
        pointsOfInterest.add(new PointOfInterest(R.string.attractions_08, R.string.add_att_08,
                R.string.pho_att_08, R.string.web_att_08, R.drawable.attractions_008));

        // Create an {@link PointOfInterestAdapter}, whose data source is a list of {@link PointOfInterest}s. The
        // adapter knows how to create list items for each item in the list.
        PointOfInterestAdapter adapter = new PointOfInterestAdapter(getActivity(), pointsOfInterest, R.color.category_attractions);

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