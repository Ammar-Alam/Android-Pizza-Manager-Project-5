package pizzaclasses;

/**
 * Enum for crust types
 * @author Ammar A
 * @author Nikhil G
 */
public enum Crust {
    /**
     * Deep dish pizza crust
     */
    DEEP_DISH("Deep Dish"),
    /**
     * Pan pizza crust
     */
    PAN("Pan"),
    /**
     * Stuffed pizza crust
     */
    STUFFED("Stuffed"),
    /**
     * Brooklyn pizza crust
     */
    BROOKLYN("Brooklyn"),
    /**
     * Thin pizza crust
     */
    THIN("Thin"),
    /**
     * Hand tossed pizza crust
     */
    HAND_TOSSED("Hand Tossed");
    /**
     * Crust type
     */
    private final String crustType;

    /**
     * Constructor for Crust
     * @param crustType Crust type
     */
    Crust(String crustType){
        this.crustType = crustType;
    }

    /**
     * Getter for crust type
     * @return Returns crust type
     */
    public String getCrustType(){
        return this.crustType;
    }
}
