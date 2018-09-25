package com.example.android.bookstorev1.data;

import android.provider.BaseColumns;

/**
 * API Contract for the Book Store app.
 */
public final class BookContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private BookContract() {}

    /**
     * Inner class that defines constant values for the books database table.
     * Each entry in the table represents a single book title.
     */
    public static final class BookEntry implements BaseColumns {

        /** Name of database table for books */
        public final static String TABLE_NAME = "books";

        /**
         * Unique ID number for the book (only for use in the database table).
         *
         * Type: INTEGER
         */
        public final static String _ID = BaseColumns._ID;

        /**
         * Title of the book.
         *
         * Type: TEXT
         */
        public final static String COLUMN_BOOK_TITLE ="title";

        /**
         * Price of the book.
         *
         * Type: REAL
         */
        public final static String COLUMN_BOOK_PRICE = "price";

        /**
         * Quantity of the book in stock.
         *
         * Type: INTEGER
         */
        public final static String COLUMN_BOOK_QUANTITY = "quantity";

        /**
         * Supplier of the book.
         *
         * Type: STRING
         */
        public final static String COLUMN_SUPPLIER_NAME = "supplier";
		
		/**
         * Telephone number of the supplier.
         *
         * Type: STRING
         */
        public final static String COLUMN_SUPPLIER_PHONE_NUMBER = "phone";
    }

}
