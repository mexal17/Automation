package task3;

import java.util.Scanner;

public class Application {

    private static String operand = "";
    private static boolean isAppQuit = false;

    public static double getResult(String operand, double firstDigit, double secondDigit) {
        double result = 0;
        switch (operand) {
            case "+":
                result = firstDigit + secondDigit;
                break;
            case "-":
                result = firstDigit - secondDigit;
                break;
            case "*":
                result = firstDigit * secondDigit;
                break;
            case "/":
                result = firstDigit / secondDigit;
                break;
        }
        return result;
    }

    private static double getDigit(Scanner scanner) {
        boolean isDigit = false;
        double digit = 0.0;
        String typedStr;

        while (!isDigit) {
            try {
                typedStr = scanner.nextLine();
                if (typedStr.equals("quit")) {
                    isAppQuit = true;
                    break;
                }
                digit = Double.parseDouble(typedStr);
                isDigit = true;
            } catch (NumberFormatException e) {
                System.out.println("---!!!--- wrong input, type correct number:");
            }
        }
        return digit;
    }

    private static void setOperand(Scanner scanner) {
        boolean isNotSign = true;
        String input;

        while (isNotSign) {
            input = scanner.nextLine();
            if (input.equals("quit")) {
                isAppQuit = true;
                break;
            }
            if (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/")) {
                operand = input;
                isNotSign = false;
            } else {
                System.out.println("---!!!--- wrong input, type correct operation sign:");
            }
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (!isAppQuit) {
            System.out.println("->> type new expression:");
            double firstDigit = getDigit(scanner);
            if (isAppQuit) {
                break;
            }
            setOperand(scanner);
            if (isAppQuit) {
                break;
            }
            double secondDigit = getDigit(scanner);
            if (isAppQuit) {
                break;
            }
            if (operand.equals("/") && secondDigit == 0) {
                System.out.println("Error: division by zero.");
                continue;
            }
            System.out.println(getResult(operand, firstDigit, secondDigit));
        }
    }
}