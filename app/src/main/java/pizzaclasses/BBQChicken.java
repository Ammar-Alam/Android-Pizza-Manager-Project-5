package pizzaclasses;

/**
 * BBQ Chicken flavor pizza
 * @author Ammar A
 * @author Nikhil G
 */
public class BBQChicken extends Pizza{
    /**
     * Small BBQChicken Pizza Price
     */
    private static final double BBQ_CHICKEN_SMALL_PRICE = 13.99;
    /**
     * Medium BBQChicken Pizza Price
     */
    private static final double BBQ_CHICKEN_MED_PRICE = 15.99;
    /**
     * Large BBQChicken Pizza Price
     */
    private static final double BBQ_CHICKEN_LARGE_PRICE = 17.99;
    /**
     * Constructor
     *
     * @param crust Crust type
     * @param size  Pizza size
     */
    public BBQChicken(Crust crust, Size size) {
        super(crust, size);
    }
    /**
     * Constructor that sets crust
     * @param crust Crust type
     */
    public BBQChicken(Crust crust) {
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
                    return BBQ_CHICKEN_SMALL_PRICE;
                case MEDIUM:
                    return BBQ_CHICKEN_MED_PRICE;
                case LARGE:
                    return BBQ_CHICKEN_LARGE_PRICE;
            }
            return BBQ_CHICKEN_SMALL_PRICE;
        }

    /**
     * Overriden toString()
     * @return String representation of pizza
     */
    @Override
    public String toString() {
        String output = this.getSize().getSize() + " BBQ Chicken Pizza On " + this.getCrust().getCrustType() + " Crust - ";
        for(Topping topping : this.getToppings()){
            output += topping.getTopping() + ", ";
        }
        output += String.valueOf(this.price());
        return output;
    }
}
