package l6task1.util;

import l6task1.constant.CoffeeSort;
import l6task1.constant.PackType;
import l6task1.constant.ProductBrand;
import l6task1.exception.FileReadingRuntimeException;
import l6task1.factory.CoffeeFactory;
import l6task1.factory.PackFactory;
import l6task1.factory.ProductFactory;
import l6task1.model.Coffee;
import l6task1.model.Pack;
import l6task1.model.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ProductGenerator {
    private static final String INPUT_FILE = "./Lecture-6/Task1/l6task1/resources/INPUT_FILE.txt";
    private static String[] coffeeType;
    private static int[] coffeePrice;
    private static int[] packCapacity;
    private static int[] packWeight;
    private static int[] packPrice;
    private static List<Coffee> allCoffees;
    private static List<Pack> allPacks;
    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();
    private static final String PATTERN = "\\d+";

    public static void readProductDataFromFile() {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(INPUT_FILE))) {
            coffeeType = fileReader.readLine().trim().split(";");
            checkInArrayToEmptyElements(coffeeType);
            coffeePrice = parseStringToIntArray(fileReader, PATTERN);
            packCapacity = parseStringToIntArray(fileReader, PATTERN);
            packWeight = parseStringToIntArray(fileReader, PATTERN);
            packPrice = parseStringToIntArray(fileReader, PATTERN);
        } catch (IOException e) {
            throw new FileReadingRuntimeException("Error during reading INPUT_FILE ->\n" + e.getMessage());
        }
    }

    private static void checkInArrayToEmptyElements(String[] coffeeType) {
        for (String type : coffeeType) {
            if (type.isEmpty()) {
                throw new IllegalArgumentException("Incorrect string format of coffeeType during reading from INPUT_FILE.txt");
            }
        }
    }

    private static int[] parseStringToIntArray(BufferedReader fileReader, String regex) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(fileReader.readLine());
        while (matcher.find()) {
            numbers.add(Integer.valueOf(matcher.group()));
        }
        return numbers.stream().mapToInt(element -> element).toArray();
    }

    private static List<Coffee> getAllCoffee() {
        return Arrays.stream(CoffeeSort.values()).map(CoffeeFactory::createCoffees).flatMap(Collection::stream).collect(Collectors.toList());
    }

    private static List<Pack> getAllPacks() {
        return Arrays.stream(PackType.values()).map(PackFactory::createPacks).flatMap(Collection::stream).collect(Collectors.toList());
    }

    public static List<Product> getAllProducts() {
        return Arrays.stream(ProductBrand.values()).map(ProductFactory::createProducts).flatMap(Collection::stream).collect(Collectors.toList());
    }

    public static Coffee getRandomCoffee() {
        if (allCoffees == null) {
            allCoffees = getAllCoffee();
        }
        if (allCoffees.isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("allCoffees list is empty");
        }
        return allCoffees.get(RANDOM.nextInt(allCoffees.size()));
    }

    public static Pack getRandomPack() {
        if (allPacks == null) {
            allPacks = getAllPacks();
        }
        if (allPacks.isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("allPacks list is empty");
        }
        return allPacks.get(RANDOM.nextInt(allPacks.size()));
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
}
