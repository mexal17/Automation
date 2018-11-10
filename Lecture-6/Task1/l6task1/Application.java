package l6task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {

    private static String[] coffeeType = {"bean", "ground", "instant"};
    private static String[] coffeeSort = {"arabica", "robusta"};
    private static int[] coffeePrice = {10, 20, 30};
    private static String[] packType = {"can", "bag"};
    private static int[] packCapacity = {50, 100, 200, 300, 500};
    private static int[] packValue = {5, 10, 20, 30, 50};
    private static int[] packPrice = {10, 20, 30, 40, 50};
    private static String[] brands = {"Tchibo", "Pele", "Nescafe", "Jacobs", "Maxwell"};
    private static Van van;

    public static String getRandomProductBrand() {
        return brands[(int) (Math.random() * 5)];
    }

    public static List<Pack> createPacks() {
        List<Pack> packs = new ArrayList<Pack>();
        for (int i = 0; i < packCapacity.length; i++) {
            Pack canPack = new Pack(packType[0], packValue[i], packPrice[i], packCapacity[i]);
            packs.add(canPack);
            Pack bagPack = new Pack(packType[1], packValue[i], 2 * packPrice[i], packCapacity[i]);
            packs.add(bagPack);
        }
        return packs;
    }

    public static List<Coffee> createCoffee() {
        List<Coffee> coffees = new ArrayList<Coffee>();
        for (int i = 0; i < coffeeType.length; i++) {
            Coffee coffeeArabica = new Coffee(coffeeType[i], coffeeSort[0], coffeePrice[i]);
            Coffee coffeeRobusta = new Coffee(coffeeType[i], coffeeSort[1], 2 * coffeePrice[i]);
            coffees.add(coffeeArabica);
            coffees.add(coffeeRobusta);
        }
        return coffees;
    }

    public static List<Product> createProducts(List<Pack> packs, List<Coffee> coffees) {
        List<Product> products = new ArrayList<>();
        for (Pack pack : packs) {
            for (Coffee coffee : coffees) {
                Product product = new Product(coffee, pack, getRandomProductBrand());
                products.add(product);
            }
        }
        return products;
    }

    public static void showCoffees(List<Coffee> coffees) {
        for (Coffee coffee : coffees) {
            System.out.println(coffee.toString());
        }
    }

    public static void showPacks(List<Pack> packs) {
        for (Pack pack : packs) {
            System.out.println(pack.toString());
        }
    }

    public static void showProducts(List<Product> products) {
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    public static int getSummaryProductsValue(List<Product> products) {
        int summaryProductsValue = 0;
        for (Product product : products) {
            summaryProductsValue += product.getValue();
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

    public static void fillVan(List<Product> products, int money) {
        Collections.shuffle(products);
        List<Product> currentProducts = new ArrayList<>();
        int currentVanValue = 0;
        for (Product product : products) {
            money -= product.getPrice();
            if (money < 0) {
                break;
            }
            currentVanValue += product.getValue();
            if (currentVanValue > van.getMaxValue()) {
                break;
            }
            currentProducts.add(product);
        }
        van.setProducts(currentProducts);
    }

    public static List<Product> getSortedProductsByPrice(List<Product> products) {
        Collections.sort(products, new PriceProductComparator());
        return products;
    }

    public static List<Product> findProducts(List<Product> products, String sort, int value) {
        List<Product> sortedProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getCoffee().getSort().equals(sort) && product.getValue() == value) {
                sortedProducts.add(product);
            }
        }
        return sortedProducts;
    }

    public static void main(String[] args) {
        List<Pack> packs = createPacks();
        List<Coffee> coffees = createCoffee();
        List<Product> products = createProducts(packs, coffees);
        System.out.println("SummaryProductsValue = " + getSummaryProductsValue(products));
        System.out.println("SummaryProductsPrice = " + getSummaryProductsPrice(products));
        System.out.println("----------------------------------");
        van = new Van(10000);
        fillVan(products, 100000);
        System.out.println("Van max value = " + van.getMaxValue());
        showProducts(van.getProducts());
        System.out.println("Sorted by price products in Van:----------------------------------");
        showProducts(getSortedProductsByPrice(van.getProducts()));
        System.out.println("Search current Product:----------------------------------");
        showProducts(findProducts(van.getProducts(), "arabica", 220));
    }
}
