package com.example.android.bookstorev2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.TextView;
import android.net.Uri;

import com.example.android.bookstorev2.data.BookContract.BookEntry;

/**
 * {@link BookCursorAdapter} is an adapter for a list or grid view
 * that uses a {@link Cursor} of pet data as its data source. This adapter knows
 * how to create list items for each row of book data in the {@link Cursor}.
 */
public class BookCursorAdapter extends CursorAdapter {

    /**
     * Constructs a new {@link BookCursorAdapter}.
     *
     * @param context The context
     * @param c       The cursor from which to get the data.
     */
    public BookCursorAdapter(Context context, Cursor c) {
        super(context, c, 0 /* flags */);
    }

    /**
     * Makes a new blank list item view. No data is set (or bound) to the views yet.
     *
     * @param context app context
     * @param cursor  The cursor from which to get the data. The cursor is already
     *                moved to the correct position.
     * @param parent  The parent to which the new view is attached to
     * @return the newly created list item view.
     */
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        // Inflate a list item view using the layout specified in list_item.xml
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        // Hook up sale button
    }

    /**
     * This method binds the book data (in the current row pointed to by cursor) to the given
     * list item layout. For example, the name for the current book can be set on the name TextView
     * in the list item layout.
     *
     * @param view    Existing view, returned earlier by newView() method
     * @param context app context
     * @param cursor  The cursor from which to get the data. The cursor is already moved to the
     *                correct row.
     */
    @Override
    public void bindView(View view, final Context context, final Cursor cursor) {
        // Create a ViewHolder to make updates with the sale button
        // Find individual views that we want to modify in the list item layout
        TextView titleTextView = (TextView) view.findViewById(R.id.title);
        TextView priceTextView = (TextView) view.findViewById(R.id.price);
        TextView quantityTextView = (TextView) view.findViewById(R.id.quantity);
        final Button sellOne = (Button) view.findViewById(R.id.sale_Btn);
        sellOne.setText(R.string.sell_one);

        // Find the columns of book attributes that we're interested in
        int titleColumnIndex = cursor.getColumnIndex(BookEntry.COLUMN_BOOK_TITLE);
        int priceColumnIndex = cursor.getColumnIndex(BookEntry.COLUMN_BOOK_PRICE);
        int quantityColumnIndex = cursor.getColumnIndex(BookEntry.COLUMN_BOOK_QUANTITY);

        // Read the book attributes from the Cursor for the current book
        String bookTitle = cursor.getString(titleColumnIndex);
        String bookPrice = cursor.getString(priceColumnIndex);
        final String bookQuantity = cursor.getString(quantityColumnIndex);

        // Update the TextViews with the attributes for the current book
        titleTextView.setText(bookTitle);
        priceTextView.setText(context.getString(R.string.price_prefix) + bookPrice);
        quantityTextView.setText(context.getString(R.string.quantity_prefix) + bookQuantity);

        sellOne.setOnClickListener(new View.OnClickListener() {
            int id = cursor.getInt(cursor.getColumnIndex(BookEntry._ID));
            Uri content = Uri.withAppendedPath(BookEntry.CONTENT_URI, Integer.toString(id));

            @Override
            public void onClick(View v) {
                // Set enabled in case quantity was updated
                sellOne.setEnabled(true);
                // Extract the current quantity
                String extractQty = bookQuantity;
                int quantity = Integer.parseInt(extractQty);
                if (quantity == 0) {
                    // Disable the sale_BTN until quantity is added
                    // to prevent a negative quantity from being obtained
                    sellOne.setEnabled(false);
                } else {
                    // decrement the current quantity by one.
                    quantity--;
                    // Write the new quantity to the database
                    ContentValues values = new ContentValues();
                    values.put(BookEntry.COLUMN_BOOK_QUANTITY, quantity);
                    // Call the ContentResolver to update the book at the given content URI.
                    context.getContentResolver().update(content, values, null, null);
                    if (quantity == 0) {
                        // If the updated quantity is 0, take away the ability to decrement
                        sellOne.setEnabled(false);
                    }
                }
            }
        });
    }
}

