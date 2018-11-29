package l6task1.factory;

import l6task1.constant.CoffeeSort;
import l6task1.model.Coffee;

import java.util.Collections;
import java.util.List;

public class CoffeeFactory {

    private CoffeeFactory() {
    }

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
