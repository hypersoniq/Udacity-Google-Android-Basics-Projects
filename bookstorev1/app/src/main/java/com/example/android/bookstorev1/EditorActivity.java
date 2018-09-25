package com.example.android.bookstorev1;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import android.widget.Toast;

import com.example.android.bookstorev1.data.BookContract;
import com.example.android.bookstorev1.data.BookDBHelper;
import com.example.android.bookstorev1.data.BookContract.BookEntry;


/**
 * Allows user to create a new pet or edit an existing one.
 */
public class EditorActivity extends AppCompatActivity {

    /** EditText field to enter the book's title */
    private EditText mTitleEditText;

    /** EditText field to enter the book's price */
    private EditText mPriceEditText;

    /** EditText field to enter the quantity of the book in inventory */
    private EditText mQuantityEditText;

    /** EditText field to enter the book supplier's name */
    private EditText mSupplierNameEditText;

    /** EditText field to enter the book supplier's phone number */
    private EditText mSupplierPhoneNumberEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        // Find all relevant views that we will need to read user input from
        mTitleEditText = (EditText) findViewById(R.id.edit_book_title);
        mPriceEditText = (EditText) findViewById(R.id.edit_book_price);
        mQuantityEditText = (EditText) findViewById(R.id.edit_book_quantity);
        mSupplierNameEditText = (EditText) findViewById(R.id.edit_book_supplier_name);
        mSupplierPhoneNumberEditText = (EditText) findViewById(R.id.edit_book_supplier_phone);

    }

    /**
     * Get user input from editor and save new pet into database.
     */
    private void insertBook() {
        // Read from input fields
        // Use trim to eliminate leading or trailing white space
        String titleString = mTitleEditText.getText().toString().trim();
        String priceString = mPriceEditText.getText().toString().trim();
        float price = Float.parseFloat(priceString);
        String quantityString = mQuantityEditText.getText().toString().trim();
        int quantity = Integer.parseInt(quantityString);
        String supplierString = mSupplierNameEditText.getText().toString().trim();
        String telephoneString = mSupplierPhoneNumberEditText.getText().toString().trim();

        // Create database helper
        BookDBHelper mDbHelper = new BookDBHelper(this);

        // Gets the database in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a ContentValues object where column names are the keys,
        // and pet attributes from the editor are the values.
        ContentValues values = new ContentValues();
        values.put(BookContract.BookEntry.COLUMN_BOOK_TITLE, titleString);
        values.put(BookContract.BookEntry.COLUMN_BOOK_PRICE, price);
        values.put(BookContract.BookEntry.COLUMN_BOOK_QUANTITY, quantity);
        values.put(BookContract.BookEntry.COLUMN_SUPPLIER_NAME, supplierString);
        values.put(BookContract.BookEntry.COLUMN_SUPPLIER_PHONE_NUMBER, telephoneString);

        // Insert a new row for a book in the database, returning the ID of that new row.
        long newRowId = db.insert(BookEntry.TABLE_NAME, null, values);

        // Show a toast message depending on whether or not the insertion was successful
        if (newRowId == -1) {
            // If the row ID is -1, then there was an error with insertion.
            Toast.makeText(this, "Error with saving book", Toast.LENGTH_SHORT).show();
        } else {
            // Otherwise, the insertion was successful and we can display a toast with the row ID.
            Toast.makeText(this, "Book saved with row id: " + newRowId, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_editor.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_editor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Save" menu option
            case R.id.action_save:
                // Save book to database
                insertBook();
                // Exit activity
                finish();
                return true;
            // Respond to a click on the "Delete" menu option
            case R.id.action_delete:
                // Do nothing for now
                return true;
            // Respond to a click on the "Up" arrow button in the app bar
            case android.R.id.home:
                // Navigate back to parent activity (CatalogActivity)
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
