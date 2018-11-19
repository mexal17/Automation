package l6task1.factories;

import l6task1.Coffee;
import l6task1.ProductGenerator;

import java.util.ArrayList;
import java.util.List;

public class RobustaCoffeeFactory implements CoffeeFactory {
    @Override
    public List<Coffee> createCoffee() {
        List<Coffee> coffees = new ArrayList<>();
        for (int i = 0; i < ProductGenerator.COFFEE_TYPE.length; i++) {
            coffees.add(new Coffee(ProductGenerator.COFFEE_TYPE[i], "robusta", 2 * ProductGenerator.COFFEE_PRICE[i]));
        }
        return coffees;
    }
}
