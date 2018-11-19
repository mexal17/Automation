package l6task1.factories;

import l6task1.Product;
import java.util.List;

public interface ProductFactory {
    List<Product> createProducts(int productsAmount);
}
