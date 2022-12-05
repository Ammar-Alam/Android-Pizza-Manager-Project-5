package pizzaclasses;

import java.util.ArrayList;

/**
 * Order object class
 * @author Ammar A
 * @author Nikhil G
 */
public class Order implements Customizable{
    /**
     * Order Number
     */
    private int orderNum;
    /**
     * List of pizzas to order
     */
    private ArrayList<Pizza> orderItems = new ArrayList<>();
    /**
     * Value of subtotal of order
     */
    private double subtotal = 0.0;
    /**
     * Value of added sales tax only
     */
    private double tax = 0.0;
    /**
     * Percentage tax charged
     */
    private static final double TAXRATE = 0.06625;

    /**
     * Constructor for order
     * @param orderNum Order number
     */
    public Order(int orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * Adds an object
     *
     * @param obj Object to add
     * @return Returns true if successful, false otherwise
     */
    @Override
    public boolean add(Object obj) {
        if(obj instanceof Pizza){
            this.orderItems.add((Pizza) obj);
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
        if(this.orderItems.isEmpty()) return false;
        if(obj instanceof Pizza && this.orderItems.contains((((Pizza) obj)))){
            this.orderItems.remove(obj);
            return true;
        }
        return false;
    }

    /**
     * Getter for order number
     * @return Return order number
     */
    public int getOrderNum() {
        return orderNum;
    }

    /**
     * Getter for list of pizzas in order
     * @return ArrayList of pizzas
     */
    public ArrayList<Pizza> getOrderItems() {
        return orderItems;
    }

    /**
     * New equals method
     * @param o Object to compare
     * @return Return true if equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderNum == order.orderNum;
    }

    /**
     * Getter for subtotal
     * @return Subtotal value
     */
    public double getSubtotal() {
        return subtotal;
    }

    /**
     * Getter for tax value
     * @return Tax value
     */
    public double getTax() {
        return tax;
    }

    /**
     * Calculates subtotal and tax
     */
    public void calculate(){
        for(Pizza pizza : orderItems){
            subtotal += pizza.price();
        }
        tax = subtotal * TAXRATE;
    }

    /**
     * Removes all pizzas from the order
     */
    public void clearOrder(){
        this.orderItems.clear();
    }
    /**
     * Creates string representation of order
     * @return Returns string form of order
     */
    @Override
    public String toString() {
        return  "Order Number " + String.valueOf(orderNum);
    }
}
