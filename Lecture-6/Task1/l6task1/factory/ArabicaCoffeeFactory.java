package l6task1.factory;

import l6task1.model.Coffee;
import l6task1.constant.CoffeeSort;
import l6task1.util.ProductGenerator;

import java.util.ArrayList;
import java.util.List;

public class ArabicaCoffeeFactory implements ICoffeeFactory {
    @Override
    public List<Coffee> createCoffee() {
        List<Coffee> coffees = new ArrayList<>();
        for (int i = 0; i < ProductGenerator.getCoffeeTypes().length; i++) {
            coffees.add(new Coffee(ProductGenerator.getCoffeeTypes()[i], CoffeeSort.ARABICA.name(), ProductGenerator.getCoffeePrices()[i]));
        }
        return coffees;
    }
}
