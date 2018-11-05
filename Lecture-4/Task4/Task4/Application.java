package Task4;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    private static ArrayList<Runner> listNotSorted;
    private static ArrayList<Runner> listSorted;

    private static void showListOfRunners(ArrayList<Runner> list){
        for (Runner runner:list) {
            runner.showRunner();
        }
    }

    private static void makeMarathon(){
        int bestTime;
        Runner bestRunner = listNotSorted.get(0);

        while (listNotSorted.size() != 0){
            bestTime = listNotSorted.get(0).getTime();

            for (Runner runner:listNotSorted) {
                if (bestTime >= runner.getTime()){
                    bestTime = runner.getTime();
                    bestRunner = runner;
                }
            }

            listSorted.add(bestRunner);
            listNotSorted.remove(bestRunner);
        }
    }

    private static void showRunnerByPlace(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("type the runner place:");
        if (scanner.hasNextInt()){
            int place = scanner.nextInt();
            if (place <= listSorted.size()){
                listSorted.get(place-1).showRunner();
            }else {
                System.out.println("Error: The is no such place. Amount of runners is "+listSorted.size());
            }
        }else{
            System.out.println("Error: Incorrect input!");
        }
    }

    private static void whoIsTheWinner(){
        System.out.println("The winner is:");
        listSorted.get(0).showRunner();
    }

    public static void main(String[] args) {

        listNotSorted = new ArrayList<Runner>();
        listSorted = new ArrayList<Runner>();

        String[] names = { "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate" };
        int[] timeResults = { 341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265 };

        for (int i = 0; i < names.length; i++) {
            Runner runner = new Runner(names[i],timeResults[i]);
            listNotSorted.add(runner);
        }
        System.out.println("------- Runners on START: -------------------");
        showListOfRunners(listNotSorted);
        System.out.println("------- Runners on FINISH:--------------------");

        makeMarathon();
        showListOfRunners(listSorted);

        showRunnerByPlace();
        whoIsTheWinner();
    }
}