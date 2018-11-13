package l4task4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Application {

    private static List<Runner> getRunners(String[] names){
        List<Runner> runners = new ArrayList<>();
        for (String name : names) {
            Runner runner = new Runner(name);
            runners.add(runner);
        }
        return runners;
    }

    private static void showListOfRunners(List<Runner> runners) {
        System.out.println(runners);
    }

    private static List<MarathonResult> getMarathonResults(List<Runner> runners, int[] timeResults) {
        List<MarathonResult> marathonResults = new ArrayList<>();
        for (int i = 0; i < timeResults.length; i++) {
            marathonResults.add(new MarathonResult(timeResults[i],runners.get(i)));
        }
        Collections.sort(marathonResults, new AscendingMarathonResultsComparator());
        for (int i = 0; i < marathonResults.size(); i++) {
            marathonResults.get(i).setPlace(i+1);
        }
        return marathonResults;
    }

    private static void showRunnerByPlace(List<MarathonResult> marathonResults) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type the runner place to get runner name and his time:");
        boolean isPlacePrinted = false;
        while(!isPlacePrinted){
            if (scanner.hasNextInt()) {
                int place = scanner.nextInt();
                if (place <= marathonResults.size()) {
                    System.out.println(marathonResults.get(place - 1).toString());
                    isPlacePrinted = true;
                } else {
                    System.out.println("Error: The is no such place. Amount of runners is " + marathonResults.size());
                }
            } else {
                System.out.println("Error: Incorrect input! Try again");
            }
        }
    }

    private static void showTheWinner(List<MarathonResult> marathonResults) {
        System.out.println("The winner is:");
        System.out.println(marathonResults.get(0).toString());
    }

    private static void showTheSecondPlaceRunner(List<MarathonResult> marathonResults){
        System.out.println("The Second Place Runner is:");
        System.out.println(marathonResults.get(1).toString());
    }

    private static void printMarathonResults(List<MarathonResult> marathonResults){
        for(MarathonResult result:marathonResults){
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        final String[] runnerNames = {"Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate"};
        final int[] timeResults = {341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265};
        List<Runner> runners = getRunners(runnerNames);
        System.out.println("------- Runners on START: -------------------");
        showListOfRunners(runners);
        System.out.println("------- Runners on FINISH:--------------------");
        List<MarathonResult> marathonResults = getMarathonResults(runners,timeResults);
        printMarathonResults(marathonResults);
        showTheWinner(marathonResults);
        showTheSecondPlaceRunner(marathonResults);
        showRunnerByPlace(marathonResults);
    }
}