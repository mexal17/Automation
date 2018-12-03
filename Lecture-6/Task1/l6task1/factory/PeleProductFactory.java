package l6task1.factory;

import l6task1.model.Product;
import l6task1.constant.ProductBrand;
import l6task1.util.ProductGenerator;
import java.util.ArrayList;
import java.util.List;

public class PeleProductFactory implements IProductFactory {
    @Override
    public List<Product> createProducts(int productsAmount) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < productsAmount; i++) {
            products.add(new Product(ProductGenerator.getRandomCoffee(), ProductGenerator.getRandomPack(), ProductBrand.PELE.name()));
        }
        return products;
    }
}
