package l6task1;

import l6task1.factories.CoffeeFactory;
import l6task1.factories.PackFactory;
import l6task1.factories.ProductFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ProductGenerator {
    private static final String INPUT_FILE = "c:/Work folder/Automation/Lesson#8/INPUT_FILE.txt";
    private static String[] coffeeType;
    private static int[] coffeePrice;
    private static int[] packCapacity;
    private static int[] packWeight;
    private static int[] packPrice;
    private static List<Coffee> allCoffees;
    private static List<Pack> allPacks;
    private static final ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();

    public static void readProductDataFromFile() {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(INPUT_FILE))) {
            coffeeType = fileReader.readLine().split(";");
            coffeePrice = parseStringToIntArrays(fileReader);
            packCapacity = parseStringToIntArrays(fileReader);
            packWeight = parseStringToIntArrays(fileReader);
            packPrice = parseStringToIntArrays(fileReader);
        } catch (IOException e) {
            throw new FileReadingRuntimeException("Error during reading INPUT_FILE ->\n" + e.getMessage());
        }
    }

    private static int[] parseStringToIntArrays(BufferedReader fileReader) throws IOException {
        return Arrays.stream(fileReader.readLine().split(";")).map(String::trim).mapToInt(Integer::parseInt).toArray();
    }

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
        return allCoffees.get(threadLocalRandom.nextInt(allCoffees.size()));
    }

    public static Pack getRandomPack() {
        if (allPacks == null) {
            allPacks = getAllPacks();
        }
        return allPacks.get(threadLocalRandom.nextInt(allPacks.size()));
    }

    public static String[] getCoffeeTypes() {
        return coffeeType;
    }

    public static int[] getCoffeePrices() {
        return coffeePrice;
    }

    public static int[] getPackCapacity() {
        return packCapacity;
    }

    public static int[] getPackWeight() {
        return packWeight;
    }

    public static int[] getPackPrices() {
        return packPrice;
    }

    private static class FileReadingRuntimeException extends RuntimeException {
        FileReadingRuntimeException(String message) {
            super(message);
        }
    }
}
