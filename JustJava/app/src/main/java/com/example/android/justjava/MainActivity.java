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

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
        int quantity = 1;

    public void submitOrder(View view) {

        CheckBox addWhipCheckbox = (CheckBox) findViewById(R.id.checkbox_whip);
        boolean addWhip = addWhipCheckbox.isChecked();
        CheckBox addChocolateCheckbox = (CheckBox) findViewById(R.id.checkbox_chocolate);
        boolean addChocolate = addChocolateCheckbox.isChecked();
        EditText nameText = (EditText) findViewById(R.id.nameText);
        String name = nameText.getText().toString();
        String priceMessage = "";
        priceMessage = getResources().getString(R.string.name_text, name)+"\n";
        priceMessage += getResources().getString(R.string.add_whip, addWhip)+"\n";
        priceMessage += getResources().getString(R.string.add_chocolate, addChocolate) +"\n";
        String price = "";
        int addons = 0;
        if(addWhip)
            addons += 1;
        if (addChocolate)
            addons += 2;

        price = displayPrice(quantity * (5 + addons));
        priceMessage += getResources().getString(R.string.total, price) + "\n"+getResources().getString(R.string.thank_you);
//        displayMessage(priceMessage);
        composeEmail(getResources().getString(R.string.email_title, name), priceMessage);
    }

    public void composeEmail(String title, String body) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, title);
        intent.putExtra(Intent.EXTRA_TEXT, body);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void increment(View view){
        Button incBtn = (Button)findViewById(R.id.incBtn);
        Button decBtn = (Button)findViewById(R.id.decBtn);
        if (quantity <= 99){
            quantity += 1;
            incBtn.setEnabled(true);
            decBtn.setEnabled(true);
        }
        if(quantity == 100) {
            incBtn.setEnabled(false);
            Context context = getApplicationContext();
            CharSequence text = getResources().getString(R.string.max_quantity);
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        display(quantity);
    }

    public void decrement(View view){
        Button decBtn = (Button)findViewById(R.id.decBtn);
        Button incBtn = (Button)findViewById(R.id.incBtn);
        if (quantity > 1){
            quantity -= 1;
            decBtn.setEnabled(true);
            incBtn.setEnabled(true);
        }
        if(quantity == 1){
            decBtn.setEnabled(false);
            Context context = getApplicationContext();
            CharSequence text = getResources().getText(R.string.min_quantity);
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        display(quantity);
    }


    /**
     * This method displays the given text on the screen.
     */
//    private void displayMessage(String message) {
//        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
//        priceTextView.setText(message);
//    }

    /**
     * This method displays the given price on the screen.
     */
    private String displayPrice(int number) {
        return NumberFormat.getCurrencyInstance().format(number);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
}

