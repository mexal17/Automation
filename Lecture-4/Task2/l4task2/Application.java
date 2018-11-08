package l4task2;

import java.time.DayOfWeek;
import java.util.Scanner;

public class Application {

    private static void printInfo(int dayNumber){
        System.out.println(DayOfWeek.of(dayNumber));
    }

    public static void main(String[] args) {
        System.out.println("type the day number: ");
        Scanner scanner = new Scanner(System.in);
        int dayNumber = scanner.nextInt();
        switch (dayNumber) {
            case 1:
                printInfo(dayNumber);
                break;
            case 2:
                printInfo(dayNumber);
                break;
            case 3:
                printInfo(dayNumber);
                break;
            case 4:
                printInfo(dayNumber);
                break;
            case 5:
                printInfo(dayNumber);
                break;
            case 6:
                printInfo(dayNumber);
                break;
            case 7:
                printInfo(dayNumber);
                break;
            default:
                System.out.println("incorrect day number");
        }
    }
}