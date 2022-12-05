package pizzaclasses;

/**
 * Meatzza flavor pizza
 * @author Ammar A
 * @author Nikhil G
 */
public class Meatzza extends Pizza{
    /**
     * Small Meatzza Pizza Price
     */
    private static final double MEATZZA_SMALL_PRICE = 15.99;
    /**
     * Medium Meatzza Pizza Price
     */
    private static final double MEATZZA_MED_PRICE = 17.99;
    /**
     * Large Meatzza Pizza Price
     */
    private static final double MEATZZA_LARGE_PRICE = 19.99;
    /**
     * Constructor
     *
     * @param crust Crust type
     * @param size  Pizza size
     */
    public Meatzza(Crust crust, Size size) {
        super(crust, size);
    }
    /**
     * Constructor that sets crust
     * @param crust Crust type
     */
    public Meatzza(Crust crust) {
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
                return MEATZZA_SMALL_PRICE;
            case MEDIUM:
                return MEATZZA_MED_PRICE;
            case LARGE:
                return MEATZZA_LARGE_PRICE;
        }
        return MEATZZA_SMALL_PRICE;
    }
    /**
     * Overriden toString()
     * @return String representation of pizza
     */
    @Override
    public String toString() {
        String output = this.getSize().getSize() + " Meatzza Pizza On " + this.getCrust().getCrustType() + " Crust - ";
        for(Topping topping : this.getToppings()){
            output += topping.getTopping() + ", ";
        }
        output += String.valueOf(this.price());
        return output;
    }
}
