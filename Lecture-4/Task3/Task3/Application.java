package Task3;

import java.util.Scanner;

public class Application {

    private static int rhombSide;
    private static StringBuffer stringBuffer1;
    private static StringBuffer stringBuffer2;
    private static int counter;
    private static StringBuffer[] mas;

    private static void printOneRow(){
        for (int i = 0; i < rhombSide; i++) {
            if (i != counter){
                stringBuffer1.append(" ");
            }else {
                stringBuffer1.append("*");
            }
        }
        stringBuffer2 = new StringBuffer(stringBuffer1);
        stringBuffer2.append(stringBuffer1.reverse().substring(1));
        System.out.println(stringBuffer2);
    }

    private static void printAnotherPartOfRhamb(){
        for (int i = (mas.length-2); i >= 0; i--) {
            System.out.println(mas[i]);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        rhombSide = scanner.nextInt();

        mas = new StringBuffer[rhombSide];

        counter = rhombSide -1;

        for (int j = 0; j < rhombSide; j++) {
            stringBuffer1 = new StringBuffer();
            printOneRow();
            counter--;
            mas[j] = new StringBuffer(stringBuffer2);
        }

        printAnotherPartOfRhamb();
    }
}
