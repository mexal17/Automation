package l6task1.util;

import l6task1.comparator.AscendingPriceProductComparator;
import l6task1.model.Product;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ProductCalculator {

    public static List<Product> getSortedProductsByPrice(List<Product> products) {
        Collections.sort(products, new AscendingPriceProductComparator());
        return products;
    }

    public static List<Product> findProducts(List<Product> products, String coffeeSort, int weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException("Incorrect value of 'weight' in 'findProducts' method");
        }
        return products.stream().filter(product -> product.getCoffee().getSort().equals(coffeeSort) && product.getWeight() == weight).collect(Collectors.toList());
    }

    public static int getProductMinPriceInList(List<Product> products) {
        return products.stream().mapToInt(Product::getPrice).min().getAsInt();
    }

    public static int getProductMinWeightInList(List<Product> products) {
        return products.stream().mapToInt(Product::getWeight).min().getAsInt();
    }
}
