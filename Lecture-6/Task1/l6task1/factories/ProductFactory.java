package l6task1.factories;

import l6task1.Product;
import l6task1.ProductBrand;

import java.util.ArrayList;
import java.util.List;

public class ProductFactory {

    public static List<Product> createProducts(ProductBrand productBrand, int productsAmount) {
        List<Product> products = new ArrayList<>();
        switch (productBrand) {
            case NESCAFE: {
                products = new NescafeProductFactory().createProducts(productsAmount);
                break;
            }
            case PELE: {
                products = new PeleProductFactory().createProducts(productsAmount);
                break;
            }
            case TCHIBO: {
                products = new TchiboProductFactory().createProducts(productsAmount);
                break;
            }
        }
        return products;
    }
}
