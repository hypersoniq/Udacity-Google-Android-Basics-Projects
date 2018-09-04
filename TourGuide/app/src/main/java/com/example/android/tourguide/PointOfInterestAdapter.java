package com.example.android.tourguide;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link PointOfInterestAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link PointOfInterest} objects.
 */
public class PointOfInterestAdapter extends ArrayAdapter<PointOfInterest> {

    /**
     * Resource ID for the background color for this list of related points of interest
     */
    private int mColorResourceId;

    /**
     * Create a new {@link PointOfInterestAdapter} object.
     *
     * @param context          is the current context (i.e. Activity) that the adapter is being created in.
     * @param pointsOfInterest is the list of {@link PointOfInterest}s to be displayed.
     * @param colorResourceId  is the resource ID for the background color for this list of words
     */
    public PointOfInterestAdapter(Context context, ArrayList<PointOfInterest> pointsOfInterest, int colorResourceId) {
        super(context, 0, pointsOfInterest);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        PointOfInterest currentPoi = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID name_text_view.
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name_text_view);
        // Get the Name from the currentPoi object and set this text on
        // the Name TextView.
        nameTextView.setText(currentPoi.getPointOfInterestName());

        // Find the TextView in the list_item.xml layout with the ID location_text_view.
        TextView locationTextView = (TextView) listItemView.findViewById(R.id.location_text_view);
        // Get the address from the currentPoi object and set this text on
        // the location TextView.
        locationTextView.setText(currentPoi.getPointOfInterestAddress());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Check if an image is provided for this point of interest or not
        if (currentPoi.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentPoi.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;

    }
}