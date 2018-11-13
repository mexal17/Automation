package l4task3;

import java.util.Scanner;

public class Application {

    private static int rhombSide;
    private static StringBuffer leftPartOfRow;
    private static StringBuffer fullRow;
    private static int counter;
    private static StringBuffer[] rowsOfHalfRhomb;

    private static void printOneRow() {
        for (int i = 0; i < rhombSide; i++) {
            if (i != counter) {
                leftPartOfRow.append(" ");
            } else {
                leftPartOfRow.append("*");
            }
        }
        fullRow = new StringBuffer(leftPartOfRow);
        fullRow.append(leftPartOfRow.reverse().substring(1));
        System.out.println(fullRow);
    }

    private static void printAnotherPartOfRhomb() {
        for (int i = (rowsOfHalfRhomb.length - 2); i >= 0; i--) {
            System.out.println(rowsOfHalfRhomb[i]);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        rhombSide = scanner.nextInt();
        rowsOfHalfRhomb = new StringBuffer[rhombSide];
        counter = rhombSide - 1;
        for (int j = 0; j < rhombSide; j++) {
            leftPartOfRow = new StringBuffer();
            printOneRow();
            counter--;
            rowsOfHalfRhomb[j] = new StringBuffer(fullRow);
        }
        printAnotherPartOfRhomb();
    }
}
