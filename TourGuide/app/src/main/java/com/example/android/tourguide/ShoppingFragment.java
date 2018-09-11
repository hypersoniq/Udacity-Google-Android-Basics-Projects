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
public class ShoppingFragment extends Fragment {

    public ShoppingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        // Create a list of points of interest for this category
        final ArrayList<PointOfInterest> pointsOfInterest = new ArrayList<PointOfInterest>();
        pointsOfInterest.add(new PointOfInterest(R.string.shopping_01, R.string.add_sho_01,
                R.string.pho_sho_01, R.string.web_sho_01, R.drawable.shopping_001));
        pointsOfInterest.add(new PointOfInterest(R.string.shopping_02, R.string.add_sho_02,
                R.string.pho_sho_02, R.string.web_sho_02, R.drawable.shopping_002));
        pointsOfInterest.add(new PointOfInterest(R.string.shopping_03, R.string.add_sho_03,
                R.string.pho_sho_03, R.string.web_sho_03, R.drawable.shopping_003));
        pointsOfInterest.add(new PointOfInterest(R.string.shopping_04, R.string.add_sho_04,
                R.string.pho_sho_04, R.string.web_sho_04, R.drawable.shopping_004));
        pointsOfInterest.add(new PointOfInterest(R.string.shopping_05, R.string.add_sho_05,
                R.string.pho_sho_05, R.string.web_sho_05, R.drawable.shopping_005));
        pointsOfInterest.add(new PointOfInterest(R.string.shopping_06, R.string.add_sho_06,
                R.string.pho_sho_06, R.string.web_sho_06, R.drawable.shopping_006));
        pointsOfInterest.add(new PointOfInterest(R.string.shopping_07, R.string.add_sho_07,
                R.string.pho_sho_07, R.string.web_sho_07, R.drawable.shopping_007));
        pointsOfInterest.add(new PointOfInterest(R.string.shopping_08, R.string.add_sho_08,
                R.string.pho_sho_08, R.string.web_sho_08, R.drawable.shopping_008));
        pointsOfInterest.add(new PointOfInterest(R.string.shopping_09, R.string.add_sho_09,
                R.string.pho_sho_09, R.string.web_sho_09, R.drawable.shopping_009));
        pointsOfInterest.add(new PointOfInterest(R.string.shopping_10, R.string.add_sho_10,
                R.string.pho_sho_10, R.string.web_sho_10, R.drawable.shopping_010));

        // Create an {@link PointOfInterestAdapter}, whose data source is a list of {@link PointOfInterest}s. The
        // adapter knows how to create list items for each item in the list.
        PointOfInterestAdapter adapter = new PointOfInterestAdapter(getActivity(), pointsOfInterest, R.color.category_shopping);

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
