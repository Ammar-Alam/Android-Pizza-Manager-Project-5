package com.application.androidpizzamanagerproject5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pizzaclasses.Pizza;

/**
 * @author Ammar A
 * @author Nikhil G
 * Custom adapter class that displays pizza objects
 */
public class OrderRecyclerAdapter extends RecyclerView.Adapter<OrderRecyclerAdapter.ViewHolder> {
    /**
     * List of pizzas
     */
    private ArrayList<Pizza> pizzaList;

    /**
     * Constructor
     * @param pizzas List of pizzas
     */
    public OrderRecyclerAdapter(ArrayList<Pizza> pizzas){
        pizzaList = pizzas;
    }

    /**
     * On create event
     * @param parent Parent
     * @param viewType Viewtype
     * @return ViewHolder object
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_pizza_view, parent, false);
        return new ViewHolder(view);
    }

    /**
     * On bind viewholder event handler
     * @param holder Viewholder
     * @param position Position
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pizza pizza = pizzaList.get(position);
        holder.pizzaDescription.setText(pizza.toString());
    }

    /**
     * Gets count of items
     * @return Count of items
     */
    @Override
    public int getItemCount() {
        return pizzaList.size();
    }

    /**
     * ViewHolder
     */
    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView pizzaDescription;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pizzaDescription = (TextView) itemView.findViewById(R.id.pizzaDescription);
        }
    }
}