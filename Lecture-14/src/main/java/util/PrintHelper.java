package util;

import java.io.IOException;
import java.net.URISyntaxException;

public class PrintHelper {

    private PrintHelper() {
    }

    public static void printInfoAboutUriSyntaxException(URISyntaxException e) {
        System.out.println("Error during parsing string as a URI reference: " + e.getMessage());
    }

    public static void printInfoAboutIoSyntaxException(IOException e) {
        System.out.println("Error during executing response: " + e.getMessage());
    }

    public static void printInfoAboutErrorDuringDeserialization(IOException e) {
        System.out.println("Error during deserialization response: " + e.getMessage());
    }
}
