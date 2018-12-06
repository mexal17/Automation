package task3;

import java.util.Scanner;

public class Calculator {
    private Operator operator;
    private boolean isAppQuit = false;
    private Scanner scanner;

    public Calculator() {
        this.scanner = new Scanner(System.in);
    }

    private double getOperand() {
        boolean isOperand = false;
        double operand = 0.0;
        String typedStr;

        while (!isOperand) {
            try {
                typedStr = scanner.nextLine();
                if (typedStr.equals("quit")) {
                    isAppQuit = true;
                    break;
                }
                operand = Double.parseDouble(typedStr);
                isOperand = true;
            } catch (NumberFormatException e) {
                System.out.println("---!!!--- wrong input, type correct number:");
            }
        }
        return operand;
    }

    private void setOperator() {
        boolean isNotOperator = true;
        String input;

        while (isNotOperator) {
            input = scanner.nextLine();
            if (input.equals("quit")) {
                isAppQuit = true;
                break;
            }
            if (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/")) {
                operator = Operator.getOperatorByString(input);
                isNotOperator = false;
            } else {
                System.out.println("---!!!--- wrong input, type correct operation sign:");
            }
        }
    }

    public double getResult(Operator operator, double firstOperand, double secondOperand) {
        switch (operator) {
            case PLUS:
                return firstOperand + secondOperand;
            case MINUS:
                return firstOperand - secondOperand;
            case MULTIPLY:
                return firstOperand * secondOperand;
            case DIVIDE:
                return firstOperand / secondOperand;
            default:
                throw new IllegalArgumentException("Incorrect operator");
        }
    }

    public void doCalculation() {
        while (!isAppQuit) {
            System.out.println("->> type new expression:");
            double firstOperand = getOperand();
            if (isAppQuit) {
                break;
            }
            setOperator();
            if (isAppQuit) {
                break;
            }
            double secondOperand = getOperand();
            if (isAppQuit) {
                break;
            }
            if (operator.equals(Operator.DIVIDE) && secondOperand == 0) {
                System.out.println("Error: division by zero.");
                continue;
            }
            System.out.println(getResult(operator, firstOperand, secondOperand));
        }
    }
}
