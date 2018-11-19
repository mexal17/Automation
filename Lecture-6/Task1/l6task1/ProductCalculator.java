package l6task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductCalculator {

    public static List<Product> getSortedProductsByPrice(List<Product> products) {
        Collections.sort(products, new AscendingPriceProductComparator());
        return products;
    }

    public static List<Product> findProducts(List<Product> products, String sort, int weight) {
        List<Product> sortedProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getCoffee().getSort().equals(sort) && product.getWeight() == weight) {
                sortedProducts.add(product);
            }
        }
        return sortedProducts;
    }

    public static int getProductMinPriceInList(List<Product> products) {
        int minPrice = products.get(0).getPrice();
        for (Product product : products) {
            minPrice = Math.min(minPrice, product.getPrice());
        }
        return minPrice;
    }

    public static int getProductMinWeightInList(List<Product> products) {
        int minWeight = products.get(0).getWeight();
        for (Product product : products) {
            minWeight = Math.min(minWeight, product.getPrice());
        }
        return minWeight;
    }
}
