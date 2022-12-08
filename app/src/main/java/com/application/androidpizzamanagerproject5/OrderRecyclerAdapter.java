package com.application.androidpizzamanagerproject5;

import android.app.LauncherActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import pizzaclasses.Pizza;

public class OrderRecyclerAdapter extends RecyclerView.Adapter<OrderRecyclerAdapter.ViewHolder> {
    private ArrayList<Pizza> pizzaList;
    public OrderRecyclerAdapter(ArrayList<Pizza> pizzas){
        pizzaList = pizzas;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_pizza_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pizza pizza = pizzaList.get(position);
        holder.pizzaDescription.setText(pizza.toString());
    }

    @Override
    public int getItemCount() {
        return pizzaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView pizzaDescription;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pizzaDescription = (TextView) itemView.findViewById(R.id.pizzaDescription);
        }
    }
}