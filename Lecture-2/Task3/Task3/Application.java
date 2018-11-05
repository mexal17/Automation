package Task3;

import java.util.Scanner;

public class Application {

    private static String operand = "";
    private static boolean flagMain = true;

    private static void getResult(String operand, double firstDigit, double secondDigit){

        switch (operand){
            case "+":
                System.out.println("result = "+(firstDigit+secondDigit));
                break;
            case "-":
                System.out.println("result = "+(firstDigit-secondDigit));
                break;
            case "*":
                System.out.println("result = "+(firstDigit*secondDigit));
                break;
            case "/":
                System.out.println("result = "+(firstDigit/secondDigit));
        }
    }

    private static double getDigit(Scanner scanner){

        boolean flag = true;
        double digit = 0.0;
        String input;

        while (flag){
            try {

                input = scanner.nextLine();

                if (input.equals("quit")){
                    flagMain = false;
                    break;
                }

                digit = Double.parseDouble(input);
                flag =false;

            } catch (NumberFormatException e) {
                System.out.println("---!!!--- wrong input, type correct number:");
            }
        }
        return digit;
    }

    private static void setOperand(Scanner scanner){

        boolean flag = true;
        String input;

        while (flag){
            input = scanner.nextLine();
            if (input.equals("quit")){
                flagMain = false;
                break;
            }
            if (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/")){
                operand = input;
                flag = false;
            }else {
                System.out.println("---!!!--- wrong input, type correct operation sign:");
            }
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (flagMain) {

            System.out.println("->> type new expression:");

            double firstDigit = getDigit(scanner);

            if (!flagMain){break;}

            setOperand(scanner);

            if (!flagMain){break;}

            double secondDigit = getDigit(scanner);

            if (!flagMain){break;}

            getResult(operand, firstDigit, secondDigit);
        }
    }
}
