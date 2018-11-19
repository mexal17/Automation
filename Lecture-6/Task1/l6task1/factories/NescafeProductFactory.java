package l6task1.factories;

import l6task1.Product;
import l6task1.ProductGenerator;

import java.util.ArrayList;
import java.util.List;

public class NescafeProductFactory implements ProductFactory {
    @Override
    public List<Product> createProducts(int productsAmount) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < productsAmount; i++) {
            products.add(new Product(ProductGenerator.getRandomCoffee(), ProductGenerator.getRandomPack(), "Nescafe"));
        }
        return products;
    }
}
