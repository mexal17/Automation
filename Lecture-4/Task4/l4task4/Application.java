package l4task4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Application {

    private static List<Runner> runners;

    private static void showListOfRunners(List<Runner> runners) {
        for (Runner runner : runners) {
            System.out.println(runner.toString());
        }
    }

    private static void makeMarathon() {
        Collections.sort(runners, new TimeRunnersComparator());
    }

    private static void showRunnerByPlace() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("type the runner place:");
        if (scanner.hasNextInt()) {
            int place = scanner.nextInt();
            if (place <= runners.size()) {
                System.out.println(runners.get(place - 1).toString());
            } else {
                System.out.println("Error: The is no such place. Amount of runners is " + runners.size());
            }
        } else {
            System.out.println("Error: Incorrect input!");
        }
    }

    private static void showTheWinner() {
        System.out.println("The winner is:");
        System.out.println(runners.get(0).toString());
    }

    public static void main(String[] args) {

        runners = new ArrayList<>();
        String[] names = {"Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate"};
        int[] timeResults = {341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265};
        for (int i = 0; i < names.length; i++) {
            Runner runner = new Runner(names[i], timeResults[i]);
            runners.add(runner);
        }
        System.out.println("------- Runners on START: -------------------");
        showListOfRunners(runners);
        System.out.println("------- Runners on FINISH:--------------------");
        makeMarathon();
        showListOfRunners(runners);
        showRunnerByPlace();
        showTheWinner();
    }
}