package Task5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    private static StringBuffer answer = new StringBuffer("Vlad Bankov");
    private static StringBuffer guess = new StringBuffer();
    private static String name = answer.substring(0,answer.indexOf(" "));
    private static String lastName = answer.substring(answer.indexOf(" ")+1);
    private static List <String> alreadyGuessedLetters = new ArrayList<>();

    private static void generateGuessPattern(){
        for (int i = 0; i < answer.length(); i++) {
            if (String.valueOf(answer.charAt(i)).equals(" ")){
                guess.append(" ");
            }else{
                guess.append("*");
            }
        }
    }

    private static boolean isAllLettersInString(String str){
        char[] masChars = str.toCharArray();
        for (char letter:masChars) {
            if (!Character.isLetter(letter)){
                return false;
            }
        }
        return true;
    }

    private static void checkGuessedLetter(String typedStr){
        boolean isLetterGuessed = false;
        for (int i = 0; i < answer.length(); i++) {
            char letter = answer.charAt(i);
            if (Character.toLowerCase(letter) == Character.toLowerCase(typedStr.charAt(0))){
                guess.replace(i,i+1,Character.toString(letter));
                isLetterGuessed = true;
            }
        }
        if (isLetterGuessed){
            showGuess();
        }else{
            System.out.println("wrong letter, try again:");
        }
    }

    private static void checkGuessedWord(String typedStr){
        int letterIndex = answer.indexOf(typedStr);
        guess.replace(letterIndex,letterIndex+typedStr.length(),typedStr);
        System.out.println("you guess the word:");
        showGuess();
    }

    private static void showGuess(){
        System.out.println("-> Success: -> "+guess);
    }

    public static void main(String[] args) {

        generateGuessPattern();
        Scanner scanner = new Scanner(System.in);
        String typedStr;
        System.out.println("try to guess the name and lastName, see the pattern below:");
        System.out.println(guess);
        System.out.println("type a letter or full name at once:");

        while (!guess.toString().equals(answer.toString())){

            typedStr = scanner.nextLine();

            if (!isAllLettersInString(typedStr)){
                System.out.println("Incorrect, type letter or word:");
                continue;
            }

            if (typedStr.length() == 1 && alreadyGuessedLetters.contains(typedStr)){
                System.out.println("You've already typed this letter. Try other.");
                continue;
            }else{
                alreadyGuessedLetters.add(typedStr);
            }

            if (typedStr.length() == 1){
                checkGuessedLetter(typedStr);
            }else if (typedStr.equals(name) || typedStr.equals(lastName)){
                checkGuessedWord(typedStr);
            }else{
                System.out.println("wrong word, try again:");
            }
        }
        System.out.println("Congratulations. You've guessed!");
    }
}