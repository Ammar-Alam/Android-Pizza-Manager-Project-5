package com.application.androidpizzamanagerproject5;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;

import pizzaclasses.Order;
import pizzaclasses.Pizza;

/**
 * @author Ammar A
 * @author Nikhil G
 * Controller class for activity_current_order.xml
 */
public class CurrentOrderActivity extends AppCompatActivity {
    /**
     * List of pizzas in current order
     */
    private ArrayList<Pizza> pizzas;
    /**
     * RecyclerView to show pizzas in
     */
    private RecyclerView orderPizzasListView;

    /**
     * Initialize activity
     * @param savedInstanceState Bundle object
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_order);
        pizzas = MainActivity.currentOrder.getOrderItems();
        orderPizzasListView = findViewById(R.id.pizzaRecyclerView);
        setAdapter();
        updateAllPriceDisplays();
        setOrderNumber();
    }

    /**
     * Sets up adapter for the RecyclerView
     */
    private void setAdapter(){
        OrderRecyclerAdapter adapter = new OrderRecyclerAdapter(pizzas);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        orderPizzasListView.setLayoutManager(layoutManager);
        orderPizzasListView.setItemAnimator(new DefaultItemAnimator());
        orderPizzasListView.setAdapter(adapter);
    }

    /**
     * Place order button press event
     * @param view Triggering view
     */
    public void placeOrder(View view){
        if(MainActivity.currentOrder.getOrderItems().isEmpty()){
            noPizzasAlert();
            return;
        }
        MainActivity.storeOrders.add(MainActivity.currentOrder);
        MainActivity.currentOrder = new Order(MainActivity.storeOrders.getNextOrderNumber());
        CurrentOrderActivity.this.finish();
    }

    /**
     * Remove selected pizza button press event
     * @param view Triggering view
     */
    public void removeSelected(View view){}

    /**
     * Clear order button press event
     * @param view Triggering view
     */
    public void clearOrder(View view){
        MainActivity.currentOrder = new Order(MainActivity.currentOrder.getOrderNum());
        CurrentOrderActivity.this.finish();
    }

    /**
     * Sets order number
     */
    private void setOrderNumber(){
        TextView orderNumber = findViewById(R.id.orderNumberView);
        orderNumber.setText(MainActivity.currentOrder.toString());
    }

    /**
     * Updates values of subtotal, sales tax, and total views
     */
    private void updateAllPriceDisplays(){
        MainActivity.currentOrder.calculate();
        updateSubtotal();
        updateSalesTax();
        updateTotal();
    }

    /**
     * Updates values of subtotal view
     */
    private void updateSubtotal(){
        double subtotal = MainActivity.currentOrder.getSubtotal();
        DecimalFormat decimalFormat = new DecimalFormat("##########.##");
        TextView display = findViewById(R.id.subtotalView);
        display.setText(decimalFormat.format(subtotal));
    }

    /**
     * Updates values of sales tax view
     */
    private void updateSalesTax(){
        double subtotal = MainActivity.currentOrder.getTax();
        DecimalFormat decimalFormat = new DecimalFormat("##########.##");
        TextView display = findViewById(R.id.salesTaxView);
        display.setText(decimalFormat.format(subtotal));
    }

    /**
     * Updates values of total view
     */
    private void updateTotal(){
        double subtotal = MainActivity.currentOrder.getTax() + MainActivity.currentOrder.getSubtotal();
        DecimalFormat decimalFormat = new DecimalFormat("##########.##");
        TextView display = findViewById(R.id.totalView);
        display.setText(decimalFormat.format(subtotal));
    }

    /**
     * Shows AlertDialog prompt
     */
    private void noPizzasAlert(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle(getResources().getString(R.string.submitOrderAlertTitle)).setMessage(getResources().getString(R.string.noPizzasInCurrentOrderWarningMessage));
        alert.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {}
        });
        alert.create().show();
    }
}