package l6task1;

import java.util.List;

public class ProductHelper {

    public static void showElementsOfCollection(List<?> collection) {
        for (Object element : collection) {
            System.out.println(element.toString());
        }
    }

    public static int getSummaryProductsValue(List<Product> products) {
        int summaryProductsValue = 0;
        for (Product product : products) {
            summaryProductsValue += product.getWeight();
        }
        return summaryProductsValue;
    }

    public static int getSummaryProductsPrice(List<Product> products) {
        int summaryProductPrice = 0;
        for (Product product : products) {
            summaryProductPrice += product.getPrice();
        }
        return summaryProductPrice;
    }
}
