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
 * A simple {@link Fragment} subclass.
 */
public class DiningFragment extends Fragment {

    public DiningFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        // Create a list of points of interest for this category
        final ArrayList<PointOfInterest> pointsOfInterest = new ArrayList<PointOfInterest>();
        pointsOfInterest.add(new PointOfInterest(R.string.dining_01, R.string.add_din_01,
                R.string.pho_din_01, R.string.web_din_01, R.drawable.ph));
        pointsOfInterest.add(new PointOfInterest(R.string.dining_02, R.string.add_din_02,
                R.string.pho_din_02, R.string.web_din_02, R.drawable.dining_002));
        pointsOfInterest.add(new PointOfInterest(R.string.dining_03, R.string.add_din_03,
                R.string.pho_din_03, R.string.web_din_03, R.drawable.ph));
        pointsOfInterest.add(new PointOfInterest(R.string.dining_04, R.string.add_din_04,
                R.string.pho_din_04, R.string.web_din_04, R.drawable.ph));
        pointsOfInterest.add(new PointOfInterest(R.string.dining_05, R.string.add_din_05,
                R.string.pho_din_05, R.string.web_din_05, R.drawable.ph));
        pointsOfInterest.add(new PointOfInterest(R.string.dining_06, R.string.add_din_06,
                R.string.pho_din_06, R.string.web_din_06, R.drawable.ph));
        pointsOfInterest.add(new PointOfInterest(R.string.dining_07, R.string.add_din_07,
                R.string.pho_din_07, R.string.web_din_07, R.drawable.ph));
        pointsOfInterest.add(new PointOfInterest(R.string.dining_08, R.string.add_din_08,
                R.string.pho_din_08, R.string.web_din_08, R.drawable.ph));
        pointsOfInterest.add(new PointOfInterest(R.string.dining_09, R.string.add_din_09,
                R.string.pho_din_09, R.string.web_din_09, R.drawable.ph));
        pointsOfInterest.add(new PointOfInterest(R.string.dining_10, R.string.add_din_10,
                R.string.pho_din_10, R.string.web_din_10, R.drawable.ph));

        // Create an {@link PointOfInterestAdapter}, whose data source is a list of {@link PointOfInterest}s. The
        // adapter knows how to create list items for each item in the list.
        PointOfInterestAdapter adapter = new PointOfInterestAdapter(getActivity(), pointsOfInterest, R.color.category_dining);

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
                poiIntent.putExtra(getString(R.string.cName), currentName);
                poiIntent.putExtra(getString(R.string.cAddress), currentAddress);
                poiIntent.putExtra(getString(R.string.cPhone), currentPhone);
                poiIntent.putExtra(getString(R.string.cWeb), currentWebsite);
                poiIntent.putExtra(getString(R.string.cImg), currentImage);
                // Start the new activity
                startActivity(poiIntent);

            }
        });

        return rootView;
    }

}
