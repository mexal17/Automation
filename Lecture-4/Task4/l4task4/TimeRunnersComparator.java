package l4task4;

import java.util.Comparator;

public class TimeRunnersComparator implements Comparator<Runner> {
    @Override
    public int compare(Runner runner1, Runner runner2) {
        Integer time1 = runner1.getTime();
        Integer time2 = runner2.getTime();
        return time1.compareTo(time2);
    }
}
