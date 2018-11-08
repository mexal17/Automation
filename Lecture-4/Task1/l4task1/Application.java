package l4task1;

import java.util.Scanner;

public class Application {
    private static Scanner scanner = new Scanner(System.in);
    private static String input;

    private static void showReverseSentence() {
        StringBuffer stringBuffer = new StringBuffer(input);
        stringBuffer.reverse();
        System.out.println("Reverse -> " + stringBuffer.toString());
    }

    private static void showSeparatedByWord() {
        String[] mas = input.split(" ");
        System.out.println("-> Separated by words: ");
        for (String word : mas) {
            System.out.println(word);
        }
    }

    private static void showChangedSpacesToStars() {
        System.out.println("showChangedSpacesToStars -> " + input.replaceAll(" ", "*"));
    }

    private static void showAllWordsUpperCase() {
        System.out.println("showAllWordsUpperCase -> " + input.toUpperCase());
    }

    private static void showFrom5To10() {
        System.out.println("showFrom5To10 -> " + input.substring(4, 10));
    }

    public static void main(String[] args) {

        input = scanner.nextLine();
        showReverseSentence();
        showSeparatedByWord();
        showChangedSpacesToStars();
        showAllWordsUpperCase();
        showFrom5To10();
    }
}
