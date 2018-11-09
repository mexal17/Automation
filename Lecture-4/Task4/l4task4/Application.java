package l4task4;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    private static ArrayList<Runner> notSortedList;
    private static ArrayList<Runner> sortedList;

    private static void showListOfRunners(ArrayList<Runner> runners) {
        for (Runner runner : runners) {
            System.out.println(runner.toString());
        }
    }

    private static void makeMarathon() {
        int bestTime;
        Runner bestRunner = notSortedList.get(0);

        while (notSortedList.size() != 0) {
            bestTime = notSortedList.get(0).getTime();
            for (Runner runner : notSortedList) {
                if (bestTime >= runner.getTime()) {
                    bestTime = runner.getTime();
                    bestRunner = runner;
                }
            }
            sortedList.add(bestRunner);
            notSortedList.remove(bestRunner);
        }
    }

    private static void showRunnerByPlace() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("type the runner place:");
        if (scanner.hasNextInt()) {
            int place = scanner.nextInt();
            if (place <= sortedList.size()) {
                System.out.println(sortedList.get(place - 1).toString());
            } else {
                System.out.println("Error: The is no such place. Amount of runners is " + sortedList.size());
            }
        } else {
            System.out.println("Error: Incorrect input!");
        }
    }

    private static void showTheWinner() {
        System.out.println("The winner is:");
        System.out.println(sortedList.get(0).toString());
    }

    public static void main(String[] args) {

        notSortedList = new ArrayList<Runner>();
        sortedList = new ArrayList<Runner>();
        String[] names = {"Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate"};
        int[] timeResults = {341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265};

        for (int i = 0; i < names.length; i++) {
            Runner runner = new Runner(names[i], timeResults[i]);
            notSortedList.add(runner);
        }
        System.out.println("------- Runners on START: -------------------");
        showListOfRunners(notSortedList);
        System.out.println("------- Runners on FINISH:--------------------");
        makeMarathon();
        showListOfRunners(sortedList);
        showRunnerByPlace();
        showTheWinner();
    }
}