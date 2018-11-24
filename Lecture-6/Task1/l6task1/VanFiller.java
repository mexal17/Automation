package l6task1;

import java.util.Collections;
import java.util.List;

public class VanFiller {

    public static void fillVan(Van van, List<Product> products, int money) {
        Collections.shuffle(products);
        int productsWeightInVan = 0;
        for (Product product : products) {
            if (money < product.getPrice() || (van.getVanCapacity() - productsWeightInVan) < product.getWeight()) {
                continue;
            } else {
                money -= product.getPrice();
                productsWeightInVan += product.getWeight();
                van.getProducts().add(product);
            }
        }
        products.removeAll(van.getProducts());
        System.out.println("----> Van is filled. \nVan capacity = " + van.getVanCapacity() +
                "\nProducts Weight in van = " + productsWeightInVan +
                "\nLeft place in van = " + (van.getVanCapacity() - productsWeightInVan) +
                "\nMin Weight In left List = " + ProductCalculator.getProductMinWeightInList(products) +
                "\nMoney is left = " + money +
                "\nMin Price In List = " + ProductCalculator.getProductMinPriceInList(products));
    }
}
