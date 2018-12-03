package l6task1.comparator;

import l6task1.model.Product;

import java.util.Comparator;

public class AscendingPriceProductComparator implements Comparator<Product> {
    @Override
    public int compare(Product product1, Product product2) {
        return Integer.compare(product1.getPrice(), product2.getPrice());
    }
}
