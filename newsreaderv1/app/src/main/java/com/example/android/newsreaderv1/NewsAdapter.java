package com.example.android.newsreaderv1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * An {@link NewsAdapter} knows how to create a list item layout for each article
 * in the data source (a list of {@link News} article objects).
 * <p>
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */
public class NewsAdapter extends ArrayAdapter<News> {

    /**
     * Constructs a new {@link NewsAdapter}.
     *
     * @param context  of the app
     * @param articles is the list of news articles, which is the data source of the adapter
     */
    public NewsAdapter(Context context, List<News> articles) {
        super(context, 0, articles);
    }

    /**
     * Returns a list item view that displays information about the news article at the given position
     * in the list of articles.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }

        // Find the earthquake at the given position in the list of earthquakes
        News currentArticle = getItem(position);

        // Find the TextView with view ID section
        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.section);
        // get the section text
        String articleSection = currentArticle.getSection();
        // Display the section that the article is under in that TextView
        magnitudeView.setText(articleSection);

        // Get the original headline string from the News object,
        String articleHeadline = currentArticle.getHeadline();
        // Find the TextView with view ID headline
        TextView headlineView = (TextView) listItemView.findViewById(R.id.headline);
        // Display the headline of the current article in that TextView
        headlineView.setText(articleHeadline);

        // Create a new Date object from the publication date of the article
        String dateObject = currentArticle.getDate();
        String[] dateArray = dateObject.split("T", 2);
        String dateOfArticle = dateArray[0];
        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        // Display the date of the current earthquake in that TextView
        dateView.setText(dateOfArticle);

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }
}
