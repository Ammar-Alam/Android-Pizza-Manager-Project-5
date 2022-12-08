package com.application.androidpizzamanagerproject5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
import android.os.Bundle;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

import pizzaclasses.Crust;
import pizzaclasses.NYPizza;
import pizzaclasses.Pizza;
import pizzaclasses.PizzaFactory;
import pizzaclasses.Size;
import pizzaclasses.Topping;

/**
 * @author Ammar A
 * @author Nikhil G
 * Controller class for activity_nyorder.xml
 */
public class NYOrderActivity extends AppCompatActivity {

    /**
     * Current pizza being made
     */
    public static Pizza currentPizza;
    /**
     * PizzaFactory object to create pizzas with
     */
    private final PizzaFactory pizzaFactory = new NYPizza();
    /**
     * Maximum number of allowed toppings
     */
    private static final int MAX_TOPPINGS = 7;

    /**
     * Sets up activity on creation
     * @param savedInstanceState Bundle object
     */
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nyorder);
        // Set up flavor selection spinner
        Spinner spinner = findViewById(R.id.flavorSelection);
        spinner.setOnItemSelectedListener(flavorSpinnerListener(spinner));
        // Set up toppings listview
        ListView toppingListView = findViewById(R.id.toppingsList);
        ArrayList<Topping> toppings = getAllToppingsList();
        ArrayAdapter<Topping> adapter = new ArrayAdapter<>(NYOrderActivity.this, android.R.layout.simple_list_item_multiple_choice, toppings);
        toppingListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        toppingListView.setAdapter(adapter);
        toppingListView.setOnItemClickListener(toppingListListener(toppingListView));
        // Set up size selection
        RadioGroup sizeSelection = findViewById(R.id.crustSize);
        sizeSelection.setOnCheckedChangeListener(sizeSelectionListener(sizeSelection));
        updatePizza();
    }

    /**
     * Method that submits pizza order
     * @param view Triggering view
     */
    public void submitOrder(View view){
        MainActivity.currentOrder.add(currentPizza);
        submissionAlert();
    }

    /**
     * Shows AlertDialog prompt
     */
    private void submissionAlert(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle(getResources().getString(R.string.submitOrderAlertTitle)).setMessage(getResources().getString(R.string.submitOrderAlertMessage));
        alert.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                NYOrderActivity.this.finish();
            }
        });
        Log.d("Parent Activity", "parent: " + NYOrderActivity.this.isChild());
        alert.create().show();
    }

    /**
     * Shows AlertDialog prompt for max toppings reached
     */
    private void maxToppingAlert(){
        AlertDialog.Builder alert = new AlertDialog.Builder(NYOrderActivity.this);
        alert.setTitle(getResources().getString(R.string.maxToppingsAlertTitle)).setMessage(getResources().getString(R.string.maxToppingsAlertMessage));
        alert.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {}
        });
        alert.create().show();
    }

    /**
     * Sets topping and crust selections for a custom pizza
     */
    private void setCustomToppings(){
        ListView toppingListView = findViewById(R.id.toppingsList);
        ArrayList<Topping> toppings = getAllToppingsList();
        ArrayAdapter<Topping> adapter = new ArrayAdapter<>(NYOrderActivity.this, android.R.layout.simple_list_item_multiple_choice, toppings);
        toppingListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        toppingListView.setAdapter(adapter);
        toppingListView.setOnItemClickListener(toppingListListener(toppingListView));
        toppingListView.setEnabled(true);
    }

    /**
     * Sets topping and crust selections for a BBQ Chicken pizza
     */
    private void setBBQChickenToppings(){
        ListView toppingListView = findViewById(R.id.toppingsList);
        ArrayList<Topping> toppings = getBBQToppingsList();
        ArrayAdapter<Topping> adapter = new ArrayAdapter<>(NYOrderActivity.this, android.R.layout.simple_list_item_1, toppings);
        toppingListView.setChoiceMode(ListView.CHOICE_MODE_NONE);
        toppingListView.setAdapter(adapter);
        toppingListView.setOnItemClickListener(toppingListListener(toppingListView));
        toppingListView.setEnabled(false);
        for(Topping topping : toppings){
            currentPizza.add(topping);
        }
    }

    /**
     * Sets topping and crust selections for a deluxe pizza
     */
    private void setDeluxeToppings(){
        ListView toppingListView = findViewById(R.id.toppingsList);
        ArrayList<Topping> toppings = getDeluxeToppingsList();
        ArrayAdapter<Topping> adapter = new ArrayAdapter<>(NYOrderActivity.this, android.R.layout.simple_list_item_1, toppings);
        toppingListView.setChoiceMode(ListView.CHOICE_MODE_NONE);
        toppingListView.setAdapter(adapter);
        toppingListView.setOnItemClickListener(toppingListListener(toppingListView));
        toppingListView.setEnabled(false);
        for(Topping topping : toppings){
            currentPizza.add(topping);
        }
    }

    /**
     * Sets topping and crust selections for a meatzza pizza
     */
    private void setMeatzzaToppings(){
        ListView toppingListView = findViewById(R.id.toppingsList);
        ArrayList<Topping> toppings = getMeatzzaToppingsList();
        ArrayAdapter<Topping> adapter = new ArrayAdapter<>(NYOrderActivity.this, android.R.layout.simple_list_item_1, toppings);
        toppingListView.setChoiceMode(ListView.CHOICE_MODE_NONE);
        toppingListView.setAdapter(adapter);
        toppingListView.setOnItemClickListener(toppingListListener(toppingListView));
        toppingListView.setEnabled(false);
        for(Topping topping : toppings){
            currentPizza.add(topping);
        }
    }

    /**
     * Updates settings for the current pizza being made, changes to appropriate image, and changes price
     */
    private void updatePizza(){
        Spinner spinner = findViewById(R.id.flavorSelection);
        String crustSelection = spinner.getSelectedItem().toString();
        TextView crustDisplay = findViewById(R.id.editCrustTypeTextView);
        ImageView pizzaImage = findViewById(R.id.pizzaImageView);
        switch (crustSelection){
            case "Custom":
                currentPizza = pizzaFactory.createBuildYourOwn();
                crustDisplay.setText(Crust.HAND_TOSSED.getCrustType());
                setCustomToppings();
                pizzaImage.setImageResource(R.drawable.ny_style_pizza_custom);
                break;
            case "BBQ Chicken":
                currentPizza = pizzaFactory.createBBQChicken();
                crustDisplay.setText(Crust.THIN.getCrustType());
                setBBQChickenToppings();
                pizzaImage.setImageResource(R.drawable.ny_style_pizza_bbq);
                break;
            case "Deluxe":
                currentPizza = pizzaFactory.createDeluxe();
                crustDisplay.setText(Crust.BROOKLYN.getCrustType());
                setDeluxeToppings();
                pizzaImage.setImageResource(R.drawable.ny_style_pizza_deluxe);
                break;
            case "Meatzza":
                currentPizza = pizzaFactory.createMeatzza();
                crustDisplay.setText(Crust.HAND_TOSSED.getCrustType());
                setMeatzzaToppings();
                pizzaImage.setImageResource(R.drawable.ny_style_pizza_meatzza);
                break;
        }
        updateSize();
        updatePrice();
    }

    /**
     * Upaates price
     */
    private void updatePrice(){
        TextView priceDisplay = findViewById(R.id.priceDisplay);
        DecimalFormat decimalFormat = new DecimalFormat("##########.##");
        String price = decimalFormat.format(currentPizza.price());
        priceDisplay.setText(price);
    }

    /**
     * Updates size
     */
    private void updateSize(){
        RadioButton small = findViewById(R.id.smallRadioButton);
        RadioButton medium = findViewById(R.id.mediumRadioButton);
        RadioButton large = findViewById(R.id.largeRadioButton);
        if(small.isChecked()){
            currentPizza.setSize(Size.SMALL);
        } else if(medium.isChecked()){
            currentPizza.setSize(Size.MEDIUM);
        } else if(large.isChecked()){
            currentPizza.setSize(Size.LARGE);
        }
    }

    /**
     * Creates an ArrayList of all the toppings
     * @return Returns ArrayList of toppings
     */
    private ArrayList<Topping> getAllToppingsList(){
        ArrayList<Topping> list = new ArrayList<>();
        list.add(Topping.SAUSAGE);
        list.add(Topping.PEPPERONI);
        list.add(Topping.GREEN_PEPPER);
        list.add(Topping.ONION);
        list.add(Topping.MUSHROOM);
        list.add(Topping.BBQ_CHICKEN);
        list.add(Topping.PROVOLONE);
        list.add(Topping.CHEDDAR);
        list.add(Topping.BEEF);
        list.add(Topping.HAM);
        return list;
    }

    /**
     * Creates an ArrayList of toppings for BBQ Chicken Pizzas
     * @return Returns ArrayList of toppings
     */
    private ArrayList<Topping> getBBQToppingsList(){
        ArrayList<Topping> list = new ArrayList<>();
        list.add(Topping.GREEN_PEPPER);
        list.add(Topping.BBQ_CHICKEN);
        list.add(Topping.PROVOLONE);
        list.add(Topping.CHEDDAR);
        return list;
    }

    /**
     * Creates an ArrayList of toppings for Deluxe Pizzas
     * @return Returns ArrayList of toppings
     */
    private ArrayList<Topping> getDeluxeToppingsList(){
        ArrayList<Topping> list = new ArrayList<>();
        list.add(Topping.SAUSAGE);
        list.add(Topping.PEPPERONI);
        list.add(Topping.GREEN_PEPPER);
        list.add(Topping.ONION);
        list.add(Topping.MUSHROOM);
        return list;
    }

    /**
     * Creates an ArrayList of toppings for Meatzza Pizzas
     * @return Returns ArrayList of toppings
     */
    private ArrayList<Topping> getMeatzzaToppingsList(){
        ArrayList<Topping> list = new ArrayList<>();
        list.add(Topping.SAUSAGE);
        list.add(Topping.PEPPERONI);
        list.add(Topping.BEEF);
        list.add(Topping.HAM);
        return list;
    }

    /**
     * Provides an on click listener for the toppings ListView
     * @param listView ListView to get listener
     * @return Returns OnItemClickListener
     */
    private AdapterView.OnItemClickListener toppingListListener(ListView listView){
        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ListView listView = findViewById(R.id.toppingsList);
                int numToppingsSelected = listView.getCheckedItemCount();
                Log.d("Topping Selection Count", String.valueOf(numToppingsSelected));
                Log.d("Selected Topping", listView.getItemAtPosition(i).toString());
                if(numToppingsSelected >= MAX_TOPPINGS){
                    maxToppingAlert();
                    if(numToppingsSelected > MAX_TOPPINGS) listView.setItemChecked(i, false);
                }
                if(listView.isItemChecked(i)){
                    currentPizza.add(listView.getItemAtPosition(i));
                } else if(!listView.isItemChecked(i)){
                    currentPizza.remove(listView.getItemAtPosition(i));
                }
                updatePrice();
            }
        };
        return listener;
    }

    /**
     * Provides an on click listener for the flavor spinner
     * @param spinner Spinner to get listener
     * @return Returns OnItemSelectedListener
     */
    private AdapterView.OnItemSelectedListener flavorSpinnerListener(Spinner spinner){
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(NYOrderActivity.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                updatePizza();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView){}
        };
        return listener;
    }

    /**
     * Provides an on checked change listener
     * @param radioGroup Radiogroup
     * @return OnCheckedChangeListener object
     */
    private RadioGroup.OnCheckedChangeListener sizeSelectionListener(RadioGroup radioGroup){
        RadioGroup.OnCheckedChangeListener listener = new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                updateSize();
                updatePrice();
            }
        };
        return listener;
    }
}