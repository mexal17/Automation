package l6task1;

import l6task1.factories.*;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ProductGenerator {
    public static final String[] COFFEE_TYPE = {"bean", "ground", "instant"};
    public static final int[] COFFEE_PRICE = {1, 2, 3};
    public static final int[] PACK_CAPACITY = {50, 100, 200, 300, 500};
    public static final int[] PACK_WEIGHT = {5, 10, 20, 30, 50};
    public static final int[] PACK_PRICE = {1, 2, 3, 4, 5};
    private static List<Coffee> arabicaCoffees = new ArabicaCoffeeFactory().createCoffee();
    private static List<Coffee> robustaCoffees = new RobustaCoffeeFactory().createCoffee();
    private static List<Pack> canPacks = new CanPackFactory().createPacks();
    private static List<Pack> bagPacks = new BagPackFactory().createPacks();
    private static List<Coffee> allCoffees = getAllCoffee();
    private static List<Pack> allPacks = getAllPacks();
    private static List<Product> tchiboProducts = new TchiboProductFactory().createProducts(10);
    private static List<Product> peleProducts = new PeleProductFactory().createProducts(10);
    private static List<Product> nescafeProducts = new NescafeProductFactory().createProducts(10);


    public static Coffee getRandomCoffee() {
        return allCoffees.get(ThreadLocalRandom.current().nextInt(allCoffees.size()));
    }

    public static List<Coffee> getAllCoffee() {
        arabicaCoffees.addAll(robustaCoffees);
        return arabicaCoffees;
    }

    public static Pack getRandomPack() {
        return allPacks.get(ThreadLocalRandom.current().nextInt(allPacks.size()));
    }

    public static List<Pack> getAllPacks() {
        canPacks.addAll(bagPacks);
        return canPacks;
    }

    public static List<Product> getAllProducts() {
        tchiboProducts.addAll(peleProducts);
        tchiboProducts.addAll(nescafeProducts);
        return tchiboProducts;
    }
}
