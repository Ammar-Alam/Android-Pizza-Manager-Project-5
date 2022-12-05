package pizzaclasses;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Store orders object
 * @author Ammar A
 * @author Nikhil G
 */
public class StoreOrders implements Customizable{
    /**
     * List of orders
     */
    private ArrayList<Order> orders = new ArrayList<>();
    /**
     * Adds an object
     *
     * @param obj Object to add
     * @return Returns true if successful, false otherwise
     */
    @Override
    public boolean add(Object obj) {
        if(obj instanceof Order){
            this.orders.add((Order) obj);
            return true;
        }
        return false;
    }
    /**
     * Removes an object
     *
     * @param obj Object to subtract
     * @return Returns true if successful, false otherwise
     */
    @Override
    public boolean remove(Object obj) {
        if(this.orders.isEmpty()) return false;
        if(obj instanceof Order && this.orders.contains((((Order) obj)))){
            this.orders.remove(obj);
            return true;
        }
        return false;
    }

    /**
     * Provides next available order number, which should be the index of the next empty spot in the list
     * @return Return order number
     */
    public int getNextOrderNumber(){
        if(!orders.isEmpty()) return orders.size();
        return 0;
    }

    /**
     * Exports store orders as a text file to public desktop
     * @return True if successful, false otherwise
     */
    public boolean export(){
        String storeOrders = "Today's orders:\n\n";
        for(Order order : orders){
            storeOrders += order.toString() + ":\n";
            for(Pizza pizza : order.getOrderItems()){
                storeOrders += "\t" + pizza.toString() + "\n";
            }
            storeOrders += "--------------------------------------------------------\n";
        }
        try {
            FileWriter writer = new FileWriter("storeOrders.txt");
            writer.write(storeOrders);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Getter for list of orders
     * @return List of orders
     */
    public ArrayList<Order> getOrders() {
        return orders;
    }
}
