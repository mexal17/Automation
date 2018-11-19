package l4task4;

public class MarathonResult {
    private int place;
    private final int time;
    private final Runner runner;

    public MarathonResult(int time, Runner runner) {
        this.time = time;
        this.runner = runner;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public int getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "place = " + place +
                ", time = " + time +
                ", runner = " + runner;
    }
}
