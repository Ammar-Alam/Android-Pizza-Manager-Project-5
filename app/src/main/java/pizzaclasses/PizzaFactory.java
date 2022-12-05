package pizzaclasses;

/**
 * Interface that contains methods for creating the 4 types of pizzas
 * @author Ammar A
 * @author Mikhil G
 */
public interface PizzaFactory {
    /**
     * Create a deluxe pizza
     * @return Returns deluxe Pizza
     */
    Pizza createDeluxe();

    /**
     * Create a Meatzza
     * @return Returns meatzza Pizza
     */
    Pizza createMeatzza();

    /**
     * Create a BBQ Chicken pizza
     * @return Returns BBQ Chicken pizza
     */
    Pizza createBBQChicken();

    /**
     * Creates BuildYourOwn Pizza
     * @return Returns BuildYourOwn Pizza
     */
    Pizza createBuildYourOwn();
}