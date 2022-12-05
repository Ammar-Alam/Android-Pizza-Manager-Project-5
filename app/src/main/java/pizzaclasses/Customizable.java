package pizzaclasses;

/**
 * Interface for customizable objects
 * @author Ammar A
 * @author Nikhil G
 */
public interface Customizable<E> {
    /**
     * Adds an object
     * @param obj Object to add
     * @return Returns true if successful, false otherwise
     */
    boolean add(Object obj);

    /**
     * Removes an object
     * @param obj Object to subtract
     * @return Returns true if successful, false otherwise
     */
    boolean remove(Object obj);
}