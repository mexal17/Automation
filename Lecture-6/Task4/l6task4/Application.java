package l6task4;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Application {

    private static SimpleDateFormat formatForDate = new SimpleDateFormat("hh:mm:ss:SSS");

    private static List<Double> getArrayList() {
        List<Double> arrayList = new ArrayList<>();
        int counter = 0;
        while (counter < 10000000) {
            arrayList.add(Math.random());
            counter++;
        }
        return arrayList;
    }

    private static List<Double> getLinkedList() {
        List<Double> linkedList = new LinkedList<>();
        int counter = 0;
        while (counter < 10000000) {
            linkedList.add(Math.random());
            counter++;
        }
        return linkedList;
    }

    private static void showTimeForAddingElementsToList(List<Double> list) {
        int counter = 0;
        Date startDate = new Date();
        while (counter < 1000) {
            list.add(5000000, Math.random());
            counter++;
        }
        Date endDate = new Date();
        long deltaTime = endDate.getTime() - startDate.getTime();
        System.out.println("startDate = " + formatForDate.format(startDate));
        System.out.println("endDate = " + formatForDate.format(endDate));
        System.out.println("deltaTime = " + deltaTime + " milliseconds");
    }

    private static void showTimeForDeletingElementsFromList(List<Double> list) {
        int counter = 0;
        Date startDate = new Date();
        while (counter < 1000) {
            list.remove(Math.random());
            counter++;
        }
        Date endDate = new Date();
        long deltaTime = endDate.getTime() - startDate.getTime();
        System.out.println("startDate = " + formatForDate.format(startDate));
        System.out.println("endDate = " + formatForDate.format(endDate));
        System.out.println("deltaTime = " + deltaTime + " milliseconds");
    }

    private static void showTimeForFindingElementsInList(List<Double> list) {
        int counter = 0;
        Date startDate = new Date();
        while (counter < 1000) {
            list.contains(Math.random());
            counter++;
        }
        Date endDate = new Date();
        long deltaTime = endDate.getTime() - startDate.getTime();
        System.out.println("startDate = " + formatForDate.format(startDate));
        System.out.println("endDate = " + formatForDate.format(endDate));
        System.out.println("deltaTime = " + deltaTime + " milliseconds");
    }

    public static void main(String[] args) {
        List<Double> arrayList = getArrayList();
        List<Double> linkedList = getLinkedList();
        System.out.println("---> Adding to ArrayList:");
        showTimeForAddingElementsToList(arrayList);
        System.out.println("---> Adding to LinkedList:");
        showTimeForAddingElementsToList(linkedList);
        System.out.println("\n---> Deleting from ArrayList:");
        showTimeForDeletingElementsFromList(arrayList);
        System.out.println("---> Deleting from LinkedList:");
        showTimeForDeletingElementsFromList(linkedList);
        System.out.println("\n---> Searching in ArrayList:");
        showTimeForFindingElementsInList(arrayList);
        System.out.println("---> Searching in LinkedList:");
        showTimeForFindingElementsInList(linkedList);
    }
}
