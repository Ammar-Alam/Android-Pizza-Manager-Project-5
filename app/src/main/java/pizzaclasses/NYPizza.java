package pizzaclasses;

/**
 * NY Pizza Factory Class
 * @author Ammar A
 * @author Nikhil G
 */
public class NYPizza implements PizzaFactory{
    /**
     * Create a deluxe pizza
     *
     * @return Returns deluxe Pizza
     */
    @Override
    public Pizza createDeluxe() {
        Pizza newPizza = new Deluxe(Crust.BROOKLYN);
        newPizza.add(Topping.SAUSAGE);
        newPizza.add(Topping.PEPPERONI);
        newPizza.add(Topping.GREEN_PEPPER);
        newPizza.add(Topping.ONION);
        newPizza.add(Topping.MUSHROOM);
        return newPizza;
    }

    /**
     * Create a Meatzza
     *
     * @return Returns meatzza Pizza
     */
    @Override
    public Pizza createMeatzza() {
        Pizza newPizza = new Meatzza(Crust.HAND_TOSSED);
        newPizza.add(Topping.SAUSAGE);
        newPizza.add(Topping.PEPPERONI);
        newPizza.add(Topping.BEEF);
        newPizza.add(Topping.HAM);
        return newPizza;
    }

    /**
     * Create a BBQ Chicken pizza
     *
     * @return Returns BBQ Chicken pizza
     */
    @Override
    public Pizza createBBQChicken() {
        Pizza newPizza = new BBQChicken(Crust.THIN);
        newPizza.add(Topping.BBQ_CHICKEN);
        newPizza.add(Topping.GREEN_PEPPER);
        newPizza.add(Topping.PROVOLONE);
        newPizza.add(Topping.CHEDDAR);
        return newPizza;
    }

    /**
     * Creates BuildYourOwn Pizza
     *
     * @return Returns BuildYourOwn Pizza
     */
    @Override
    public Pizza createBuildYourOwn() {
        return new BuildYourOwn(Crust.HAND_TOSSED);
    }
}
