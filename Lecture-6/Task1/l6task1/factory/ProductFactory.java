package l6task1.factory;

import l6task1.constant.ProductBrand;
import l6task1.model.Product;

import java.util.Collections;
import java.util.List;

public class ProductFactory {
    private static final int PRODUCTS_AMOUNT = 50;

    private ProductFactory() {
    }

    public static List<Product> createProducts(ProductBrand productBrand) {
        switch (productBrand) {
            case NESCAFE: {
                return new NescafeProductFactory().createProducts(PRODUCTS_AMOUNT);
            }
            case PELE: {
                return new PeleProductFactory().createProducts(PRODUCTS_AMOUNT);
            }
            case TCHIBO: {
                return new TchiboProductFactory().createProducts(PRODUCTS_AMOUNT);
            }
            default: {
                return Collections.emptyList();
            }
        }
    }
}
