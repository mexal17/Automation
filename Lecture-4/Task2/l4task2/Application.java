package l4task2;

import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.util.Scanner;

public class Application {

    private static void printInfo(int dayNumber) {
        System.out.println(DayOfWeek.of(dayNumber));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isExit = false;
        while (!isExit) {
            try {
                System.out.println("type the day number: ");
                int dayNumber = Integer.valueOf(scanner.nextLine());
                printInfo(dayNumber);
                isExit = true;
            } catch (DateTimeException e1) {
                System.out.println(e1);
            } catch (NumberFormatException e2) {
                System.out.println(e2);
            }
        }
    }
}