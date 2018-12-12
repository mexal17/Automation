package l6task4;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class Application {

    private static final int INDEX = 5000000;

    private static SimpleDateFormat formatForDate = new SimpleDateFormat("hh:mm:ss:SSS");

    private static double getMathRandom(){
        return Math.random();
    }

    private static List<Double> getFilledList(List<Double> list){
        int counter = 0;
        while (counter < 10000000) {
            list.add(Math.random());
            counter++;
        }
        return list;
    }

    private static void makeListOperation(List<Double> list, Consumer<List<Double>> operation){
        int counter = 0;
        Date startDate = new Date();
        while (counter < 1000) {
            operation.accept(list);
            counter++;
        }
        Date endDate = new Date();
        long deltaTime = endDate.getTime() - startDate.getTime();
        System.out.println("startDate = " + formatForDate.format(startDate));
        System.out.println("endDate = " + formatForDate.format(endDate));
        System.out.println("deltaTime = " + deltaTime + " milliseconds");
    }

    public static void main(String[] args) {
        List<Double> arrayList = getFilledList(new ArrayList<>());
        List<Double> linkedList = getFilledList(new LinkedList<>());
        System.out.println("---> Adding to ArrayList 1000 elements:");
        makeListOperation(arrayList,list -> list.add(INDEX, getMathRandom()));
        System.out.println("---> Adding to LinkedList 1000 elements:");
        makeListOperation(linkedList,list -> list.add(INDEX, getMathRandom()));
        System.out.println("\n---> Deleting from ArrayList 1000 elements:");
        makeListOperation(arrayList,list -> list.remove(Math.random()));
        System.out.println("---> Deleting from LinkedList 1000 elements:");
        makeListOperation(linkedList,list -> list.remove(Math.random()));
        System.out.println("\n---> Searching in ArrayList 1000 elements:");
        makeListOperation(arrayList,list -> list.contains(Math.random()));
        System.out.println("---> Searching in LinkedList 1000 elements:");
        makeListOperation(linkedList,list -> list.contains(Math.random()));
    }
}
