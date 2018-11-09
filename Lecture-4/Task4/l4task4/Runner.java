package l4task4;

public class Runner {

    private final String name;
    private final int time;

    public int getTime() {
        return time;
    }

    public Runner(String name, int time) {
        this.name = name;
        this.time = time;
    }

    public String toString() {
        return "" + name + " -> " + time;
    }
}