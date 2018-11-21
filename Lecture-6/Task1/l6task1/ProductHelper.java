package l6task1;

import java.util.List;

public class ProductHelper {

    public static void showElementsOfCollection(List<?> collection) {
        collection.forEach(System.out::println);
    }

    public static int getSummaryProductsWeight(List<Product> products){
        return products.stream().map(Product::getWeight).reduce(0,(weight, sum) -> weight+sum);
    }

    public static int getSummaryProductsPrice(List<Product> products) {
        return products.stream().map(Product::getPrice).reduce(0,(price,sum) -> price+sum);
    }
}
