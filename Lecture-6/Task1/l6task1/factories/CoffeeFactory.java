package l6task1.factories;

import l6task1.Coffee;
import l6task1.CoffeeSort;

import java.util.Collections;
import java.util.List;

public class CoffeeFactory {
    public static List<Coffee> createCoffees(CoffeeSort coffeeSort) {
        switch (coffeeSort) {
            case ARABICA: {
                return new ArabicaCoffeeFactory().createCoffee();
            }
            case ROBUSTA: {
                return new RobustaCoffeeFactory().createCoffee();
            }
            default: {
                return Collections.emptyList();
            }
        }
    }
}
