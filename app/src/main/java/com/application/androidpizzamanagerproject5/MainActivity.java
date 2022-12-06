package com.application.androidpizzamanagerproject5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import pizzaclasses.ChicagoPizza;
import pizzaclasses.Order;
import pizzaclasses.Pizza;
import pizzaclasses.Size;
import pizzaclasses.StoreOrders;

public class MainActivity extends AppCompatActivity {
    public static StoreOrders storeOrders = new StoreOrders();
    public static Order currentOrder = new Order(storeOrders.getNextOrderNumber());
    /**
     * Initialize MainActivity
     * @param savedInstanceState Bundle object
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Main:Current Order", currentOrder.toString());
        Log.d("Main:Current Order Contents", currentOrder.getOrderItems().toString());
    }

    /**
     * Launches NY Order Activity
     * @param view View
     */
    public void launchNYOrderActivity(View view){
        Intent intent = new Intent(this, NYOrderActivity.class);
        startActivity(intent);
    }
    /**
     * Launches Chicago Order Activity
     * @param view View
     */
    public void launchChicagoOrderActivity(View view){
        Intent intent = new Intent(this, ChicagoOrderActivity.class);
        startActivity(intent);
    }
    /**
     * Launches Current Order Activity
     * @param view View
     */
    public void launchCurrentOrderActivity(View view){
        Intent intent = new Intent(this, CurrentOrderActivity.class);
        startActivity(intent);
    }
    /**
     * Launches Store Orders Activity
     * @param view View
     */
    public void launchStoreOrdersActivity(View view){
        Intent intent = new Intent(this, StoreOrdersActivity.class);
        startActivity(intent);
    }
}