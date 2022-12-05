package pizzaclasses;

/**
 * Enum containing pizza toppings
 * @author Ammar A
 * @author Nikhil G
 */
public enum Topping {
    /**
     * Sausage
     */
    SAUSAGE("Sausage"),
    /**
     * Pepperoni
     */
    PEPPERONI("Pepperoni"),
    /**
     * Green pepper
     */
    GREEN_PEPPER("Green Pepper"),
    /**
     * Onion
     */
    ONION("Onion"),
    /**
     * Mushroom
     */
    MUSHROOM("Mushroom"),
    /**
     * BBQ Chicken
     */
    BBQ_CHICKEN("BBQ Chicken"),
    /**
     * Provolone
     */
    PROVOLONE("Provolone"),
    /**
     * Cheddar
     */
    CHEDDAR("Cheddar"),
    /**
     * Beef
     */
    BEEF("Beef"),
    /**
     * Ham
     */
    HAM("Ham");
    /**
     * Topping
     */
    private final String topping;

    /**
     * Constructor
     * @param topping Topping
     */
    Topping(String topping) {
        this.topping = topping;
    }

    /**
     * Returns string form of topping
     * @return Topping
     */
    public String getTopping(){return this.topping;}
}
