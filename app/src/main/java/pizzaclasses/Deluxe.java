package pizzaclasses;

/**
 * Deluxe flavor pizza
 * @author Ammar A
 * @author Nikhil G
 */public class Deluxe extends Pizza{
    /**
     * Small Deluxe Pizza Price
     */
    private static final double DELUXE_SMALL_PRICE = 14.99;
    /**
     * Medium Deluxe Pizza Price
     */
    private static final double DELUXE_MED_PRICE = 16.99;
    /**
     * Large Deluxe Pizza Price
     */
    private static final double DELUXE_LARGE_PRICE = 18.99;

    /**
     * Constructor
     *
     * @param crust Crust type
     * @param size  Pizza size
     */
    public Deluxe(Crust crust, Size size) {
        super(crust, size);
    }
    /**
     * Constructor that sets crust
     * @param crust Crust type
     */
    public Deluxe(Crust crust) {
        super(crust);
    }
    /**
     * Gives price of Pizza
     *
     * @return Returns price
     */
    @Override
    public double price() {
        switch (this.getSize()){
            case SMALL:
                return DELUXE_SMALL_PRICE;
            case MEDIUM:
                return DELUXE_MED_PRICE;
            case LARGE:
                return DELUXE_LARGE_PRICE;
        }
        return DELUXE_SMALL_PRICE;
    }
    /**
     * Overriden toString()
     * @return String representation of pizza
     */
    @Override
    public String toString() {
        String output = this.getSize().getSize() + " Deluxe Pizza On " + this.getCrust().getCrustType() + " Crust - ";
        for(Topping topping : this.getToppings()){
            output += topping.getTopping() + ", ";
        }
        output += String.valueOf(this.price());
        return output;
    }
}
