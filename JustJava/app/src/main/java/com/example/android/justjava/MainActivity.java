package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 1; // Default number of cups present on the order form
    int pricePerCup = 5; // Default price of a cup of coffee
    String customer = "Kaptain Kunal";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the increment button is clicked.
     */
    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
        Button minus = (Button) findViewById(R.id.decrement_btn);
        minus.setEnabled(true);
    }

    /**
     * This method is called when the decrement button is clicked.
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        displayQuantity(quantity);
        if (quantity == 0){
            Button minus = (Button) findViewById(R.id.decrement_btn);
            minus.setEnabled(false);
        }
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price;
        // Obtain the state of the Whipped Cream checkbox
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        // Obtain the state of the Chocolate checkbox
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();
        price = calculatePrice(quantity, pricePerCup);
        String priceMessage = createOrderSummary(price, hasWhippedCream, hasChocolate);
        displayMessage(priceMessage);
    }

    /**
     * Calculates the price of the order.
     *
     * @param orderQuantity is the number of cups of coffee ordered
     * @param unitPrice is the price per cup of coffee
     */
    private int calculatePrice(int orderQuantity, int unitPrice) {
        int totalPrice = orderQuantity * unitPrice;
        return totalPrice;
    }

    /**
     * Displays a summary of the order.
     *
     * @param price The total cost of the order
     * @param addWhippedCream State of the Whipped Cream check box
     * @param addChocolate State of the chocolate check box
     * @return orderSummary is the string displaying the final amount due
     */
    private String createOrderSummary(int price, boolean addWhippedCream, boolean addChocolate) {
        String orderSummary = "Name: " + customer;
        orderSummary +=  "\nAdd Whipped Cream? " + addWhippedCream;
        orderSummary +=  "\nAdd Chocolate? " + addChocolate;
        orderSummary +=  "\nQuantity: " + quantity;
        orderSummary +=  "\nTotal: $" + price;
        orderSummary +=  "\nThank you!";
        return orderSummary;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}