package l6task1.factories;

import l6task1.Coffee;
import l6task1.CoffeeSort;

import java.util.ArrayList;
import java.util.List;

public class CoffeeFactory {

    public static List<Coffee> createCoffees(CoffeeSort coffeeSort) {
        List<Coffee> coffees = new ArrayList<>();
        switch (coffeeSort) {
            case ARABICA: {
                coffees = new ArabicaCoffeeFactory().createCoffee();
                break;
            }
            case ROBUSTA: {
                coffees = new RobustaCoffeeFactory().createCoffee();
                break;
            }
        }
        return coffees;
    }
}
