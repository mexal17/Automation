package l6task1;

import l6task1.factories.CoffeeFactory;
import l6task1.factories.PackFactory;
import l6task1.factories.ProductFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ProductGenerator {
    public static final String[] COFFEE_TYPE = {"bean", "ground", "instant"};
    public static final int[] COFFEE_PRICE = {1, 2, 3};
    public static final int[] PACK_CAPACITY = {50, 100, 200, 300, 500};
    public static final int[] PACK_WEIGHT = {5, 10, 20, 30, 50};
    public static final int[] PACK_PRICE = {1, 2, 3, 4, 5};
    private static List<Coffee> allCoffees;
    private static List<Pack> allPacks;
    private static ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();

    private static List<Coffee> getAllCoffee() {
        List<Coffee> allCoffees = new ArrayList<>();
        for (CoffeeSort coffeeSort : CoffeeSort.values()) {
            allCoffees.addAll(CoffeeFactory.createCoffees(coffeeSort));
        }
        return allCoffees;
    }

    private static List<Pack> getAllPacks() {
        List<Pack> allPacks = new ArrayList<>();
        for (PackType packType : PackType.values()) {
            allPacks.addAll(PackFactory.createPacks(packType));
        }
        return allPacks;
    }

    public static List<Product> getAllProducts() {
        List<Product> allProducts = new ArrayList<>();
        for (ProductBrand brand : ProductBrand.values()) {
            allProducts.addAll(ProductFactory.createProducts(brand, 50));
        }
        return allProducts;
    }

    public static Coffee getRandomCoffee() {
        if (allCoffees == null) {
            allCoffees = getAllCoffee();
        }
        return allCoffees.get(ThreadLocalRandom.current().nextInt(allCoffees.size()));
    }

    public static Pack getRandomPack() {
        if (allPacks == null) {
            allPacks = getAllPacks();
        }
        return allPacks.get(threadLocalRandom.nextInt(allPacks.size()));
    }

    public static String[] getCoffeeTypes() {
        return COFFEE_TYPE;
    }

    public static int[] getCoffeePrices() {
        return COFFEE_PRICE;
    }

    public static int[] getPackCapacity() {
        return PACK_CAPACITY;
    }

    public static int[] getPackWeight() {
        return PACK_WEIGHT;
    }

    public static int[] getPackPrices() {
        return PACK_PRICE;
    }
}
