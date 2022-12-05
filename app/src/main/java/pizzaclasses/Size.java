package pizzaclasses;
/**
 * Enum containing pizza sizes
 * @author Ammar A
 * @author Nikhil G
 */
public enum Size {
    /**
     * Small
     */
    SMALL("Small"),
    /**
     * Medium
     */
    MEDIUM("Medium"),
    /**
     * Large
     */
    LARGE("Large");
    /**
     * Size of pizza
     */
    private final String size;

    /**
     * Constructor
     * @param size Size
     */
    Size(String size){
        this.size = size;
    }

    /**
     * Returns string form of size
     * @return String form of size
     */
    public String getSize() {return this.size;}
}
