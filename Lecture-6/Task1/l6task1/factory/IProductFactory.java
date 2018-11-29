package l6task1.factory;

import l6task1.model.Product;
import java.util.List;

public interface IProductFactory {
    List<Product> createProducts(int productsAmount);
}
