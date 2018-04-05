package com.example.android.justjava;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 1; // Default number of cups present on the order form
    int pricePerCup = 5; // Default price of a cup of coffee
    String customer = " ";
    EditText orderingCustomer;

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
        if (quantity >= 100){
            Button plus = (Button) findViewById(R.id.increment_btn);
            plus.setEnabled(false);
            Context context = getApplicationContext();
            CharSequence text = getString(R.string.max_cup_msg);
            int duration = Toast.LENGTH_SHORT;
            Toast.makeText(context, text, duration).show();
            return;
        }

    }

    /**
     * This method is called when the decrement button is clicked.
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        Button plus = (Button) findViewById(R.id.increment_btn);
        plus.setEnabled(true);
        if (quantity == 0){
            Button minus = (Button) findViewById(R.id.decrement_btn);
            minus.setEnabled(false);
            Context context = getApplicationContext();
            CharSequence text = getString(R.string.min_cups_msg);
            int duration = Toast.LENGTH_SHORT;
            Toast.makeText(context, text, duration).show();
        }
        displayQuantity(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price;
        // Obtain customer name
        orderingCustomer = (EditText) findViewById(R.id.customer_name);
        customer = orderingCustomer.getText().toString();
        // Obtain the state of the Whipped Cream checkbox
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        // Obtain the state of the Chocolate checkbox
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();
        price = calculatePrice(quantity, pricePerCup, hasWhippedCream, hasChocolate);
        String priceMessage = createOrderSummary(price, hasWhippedCream, hasChocolate);
        // Email intent for order summary
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse(getString(R.string.mailTo))); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.order_subject) + customer);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * Calculates the price of the order.
     *
     * @param orderQuantity is the number of cups of coffee ordered
     * @param unitPrice is the price per cup of coffee
     * @param cream if the customer ordered whipped cream
     * @param chocolate if the customer ordered chocolate
     */
    private int calculatePrice(int orderQuantity, int unitPrice, boolean cream, boolean chocolate) {
        if (cream){
            unitPrice += 1;
        }
        if (chocolate) {
            unitPrice += 2;
        }
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
        String orderSummary = getString(R.string.name) + customer;
        orderSummary +=  getString(R.string.new_line) + getString(R.string.add_cream) + addWhippedCream;
        orderSummary +=  getString(R.string.new_line) + getString(R.string.add_chocolate) + addChocolate;
        orderSummary +=  getString(R.string.new_line) + getString(R.string.quantity) + quantity;
        orderSummary +=  getString(R.string.new_line) + getString(R.string.total) + price;
        orderSummary +=  getString(R.string.new_line) + getString(R.string.thanks);
        return orderSummary;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

}