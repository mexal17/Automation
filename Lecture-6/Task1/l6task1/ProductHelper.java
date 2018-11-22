package l6task1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ProductHelper {
    private static final String OUTPUT_FILE = "c:/Work folder/Automation/Lesson#8/OUTPUT_FILE.txt";
    private static final SimpleDateFormat formatForDate = new SimpleDateFormat("hh:mm:ss:SSS");

    public static void printElementsOfCollection(List<?> collection) {
        collection.forEach(System.out::println);
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(OUTPUT_FILE, true))) {
            fileWriter.write("------- Start of printing...\nPrint time: " + formatForDate.format(new Date()) + "\n");
            for (Object element : collection) {
                fileWriter.write(element.toString() + "\n");
            }
            fileWriter.write("------- End of printing\n");
        } catch (IOException e) {
            throw new FileWritingRuntimeException("Error during writing OUTPUT_FILE.txt ->\n" + e.getMessage());
        }
    }

    public static int getSummaryProductsWeight(List<Product> products) {
        return products.stream().map(Product::getWeight).reduce(0, (weight, sum) -> weight + sum);
    }

    public static int getSummaryProductsPrice(List<Product> products) {
        return products.stream().map(Product::getPrice).reduce(0, (price, sum) -> price + sum);
    }

    private static class FileWritingRuntimeException extends RuntimeException {
        FileWritingRuntimeException(String message) {
        }
    }
}
