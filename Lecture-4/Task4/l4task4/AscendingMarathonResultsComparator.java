package l4task4;

import java.util.Comparator;

public class AscendingMarathonResultsComparator implements Comparator<MarathonResult> {

    @Override
    public int compare(MarathonResult result1, MarathonResult result2) {
        return Integer.valueOf(result1.getTime()).compareTo(Integer.valueOf(result2.getTime()));
    }
}
