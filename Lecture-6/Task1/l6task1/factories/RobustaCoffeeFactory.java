package l6task1.factories;

import l6task1.Coffee;
import l6task1.CoffeeSort;
import l6task1.ProductGenerator;

import java.util.ArrayList;
import java.util.List;

public class RobustaCoffeeFactory implements ICoffeeFactory {
    @Override
    public List<Coffee> createCoffee() {
        List<Coffee> coffees = new ArrayList<>();
        for (int i = 0; i < ProductGenerator.getCoffeeTypes().length; i++) {
            coffees.add(new Coffee(ProductGenerator.getCoffeeTypes()[i], CoffeeSort.ROBUSTA.name(), 2 * ProductGenerator.getCoffeePrices()[i]));
        }
        return coffees;
    }
}
