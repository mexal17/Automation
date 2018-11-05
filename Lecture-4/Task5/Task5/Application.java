package Task5;

import java.util.Scanner;

public class Application {

    private static StringBuffer answer = new StringBuffer("Vlad Bankov");
    private static StringBuffer guess = new StringBuffer("**** ******");
    private static String name = answer.substring(0,answer.indexOf(" "));
    private static String lastName = answer.substring(answer.indexOf(" ")+1);

    private static boolean isLetters(String str){
        char[] masChars = str.toCharArray();
        for (char letter:masChars) {
            if (!Character.isLetter(letter)){
                return false;
            }
        }
        return true;
    }

    private static void showGuess(){
        System.out.println("-> Success: -> "+guess);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String inputStr;
        System.out.println("try to guess the name and lastName, see the pattern below:");
        System.out.println(guess);
        System.out.println("type a letter or full name at once:");

        while (!guess.toString().equals(answer.toString())){

            inputStr = scanner.nextLine();

            if (!isLetters(inputStr)){
                System.out.println("Incorrect, type letter or word:");
                continue;
            }

//            доделать проверку на уже названные буквы

            if (inputStr.length() == 1){
                boolean flag = false;
                for (int i = 0; i < answer.length(); i++) {
                    char letter = answer.charAt(i);
                    if (letter == inputStr.charAt(0)){
                        guess.replace(i,i+1,inputStr);
                        flag = true;
                    }
                }
                if (flag){
                    showGuess();
                }else{
                    System.out.println("wrong letter, try again:");
                }
            }else if (inputStr.equals(name) || inputStr.equals(lastName)){
                int letterIndex = answer.indexOf(inputStr);
                guess.replace(letterIndex,letterIndex+inputStr.length(),inputStr);
                System.out.println("you guess the word:");
                showGuess();
            }else{
                System.out.println("wrong word, try again:");
            }
        }
        System.out.println("Congratulations. You've guess!");
    }
}

