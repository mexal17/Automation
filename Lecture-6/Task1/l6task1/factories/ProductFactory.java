package l6task1.factories;

import l6task1.Product;
import l6task1.ProductBrand;

import java.util.Collections;
import java.util.List;

public class ProductFactory {

    public static List<Product> createProducts(ProductBrand productBrand) {
        switch (productBrand) {
            case NESCAFE: {
                return new NescafeProductFactory().createProducts(50);
            }
            case PELE: {
                return new PeleProductFactory().createProducts(50);
            }
            case TCHIBO: {
                return new TchiboProductFactory().createProducts(50);
            }
            default: {
                return Collections.emptyList();
            }
        }
    }
}
