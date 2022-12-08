package com.application.androidpizzamanagerproject5;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

import pizzaclasses.Order;
import pizzaclasses.Pizza;

/**
 * @author Ammar A
 * @author Nikhil G
 * Controller class for activity_store_orders.xml
 */
public class StoreOrdersActivity extends AppCompatActivity {

    /**
     * List of store orders
     */
    private ArrayList<Order> orders = MainActivity.storeOrders.getOrders();
    /**
     * List of the current order's pizzas
     */
    private ArrayList<Pizza> currentOrderPizzas;
    /**
     * RecyclerView to display pizzas in
     */
    private RecyclerView orderPizzasListView;
    /**
     * Spinner that chooses selected order
     */
    private Spinner orderSpinner;

    /**
     * Initialize activity
     * @param savedInstanceState Bundle object
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Orders", MainActivity.storeOrders.getOrders().toString());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_orders);
        orderPizzasListView = findViewById(R.id.viewSelectedOrderView);
        orderSpinner = findViewById(R.id.selectOrderSpinner);
        setSpinnerAdapter();
    }

    /**
     * Sets up adapter for the RecyclerView
     */
    private void setViewAdapter(){
        OrderRecyclerAdapter adapter = new OrderRecyclerAdapter(currentOrderPizzas);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        orderPizzasListView.setLayoutManager(layoutManager);
        orderPizzasListView.setItemAnimator(new DefaultItemAnimator());
        orderPizzasListView.setAdapter(adapter);
    }

    /**
     * Sets spinner adapter
     */
    private void setSpinnerAdapter(){
        ArrayAdapter<Order> arrayAdapter = new ArrayAdapter<Order>(this, android.R.layout.simple_spinner_item, orders);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        orderSpinner.setAdapter(arrayAdapter);
        orderSpinner.setOnItemSelectedListener(currentOrderSpinnerListener(orderSpinner));
    }
    /**
     * Provides an on click listener for the current order spinner
     * @param spinner Spinner to get listener
     * @return Returns OnItemSelectedListener
     */
    private AdapterView.OnItemSelectedListener currentOrderSpinnerListener(Spinner spinner){
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Button cancelButton = findViewById(R.id.cancelSelectedOrderButton);
                cancelButton.setText(getResources().getString(R.string.cancelSelectedOrderButton));
                cancelButton.setEnabled(true);
                currentOrderPizzas = ((Order)(orderSpinner.getItemAtPosition(i))).getOrderItems();
                setViewAdapter();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView){
                Button cancelButton = findViewById(R.id.cancelSelectedOrderButton);
                cancelButton.setEnabled(false);
                cancelButton.setText(getResources().getString(R.string.cancelSelectedOrderButtonNoOrders));
            }
        };
        return listener;
    }

    /**
     * Cencels currently selected order
     * @param view Triggering view
     */
    public void cancelCurrentOrder(View view){
        Order orderToRemove = (Order) orderSpinner.getSelectedItem();
        if(orderToRemove == null){
            return;
        }
        MainActivity.storeOrders.remove(orderToRemove);
        orderCancelledAlert();
    }

    /**
     * Shows AlertDialog prompt
     */
    private void orderCancelledAlert(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle(getResources().getString(R.string.orderCancelledTitle)).setMessage(getResources().getString(R.string.orderCancelledMessage));
        alert.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                StoreOrdersActivity.this.finish();
            }
        });
        alert.create().show();
    }

}