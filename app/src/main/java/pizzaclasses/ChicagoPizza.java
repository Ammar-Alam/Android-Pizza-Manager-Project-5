package pizzaclasses;

/**
 * Chicago pizza object
 * @author Ammar A
 * @author Nikhil G
 */
public class ChicagoPizza implements PizzaFactory{
    /**
     * Create a deluxe pizza
     * @return Returns deluxe Pizza
     */
    @Override
    public Pizza createDeluxe() {
        Pizza newPizza = new Deluxe(Crust.DEEP_DISH);
        newPizza.add(Topping.SAUSAGE);
        newPizza.add(Topping.PEPPERONI);
        newPizza.add(Topping.GREEN_PEPPER);
        newPizza.add(Topping.ONION);
        newPizza.add(Topping.MUSHROOM);
        return newPizza;
    }

    /**
     * Create a Meatzza
     * @return Returns meatzza Pizza
     */
    @Override
    public Pizza createMeatzza() {
        Pizza newPizza = new Meatzza(Crust.STUFFED);
        newPizza.add(Topping.SAUSAGE);
        newPizza.add(Topping.PEPPERONI);
        newPizza.add(Topping.BEEF);
        newPizza.add(Topping.HAM);
        return newPizza;
    }

    /**
     * Create a BBQ Chicken pizza
     * @return Returns BBQ Chicken pizza
     */
    @Override
    public Pizza createBBQChicken() {
        Pizza newPizza = new BBQChicken(Crust.PAN);
        newPizza.add(Topping.BBQ_CHICKEN);
        newPizza.add(Topping.GREEN_PEPPER);
        newPizza.add(Topping.PROVOLONE);
        newPizza.add(Topping.CHEDDAR);
        return newPizza;
    }

    /**
     * Creates BuildYourOwn Pizza
     * @return Returns BuildYourOwn Pizza
     */
    @Override
    public Pizza createBuildYourOwn() {
        return new BuildYourOwn(Crust.PAN);
    }
}
