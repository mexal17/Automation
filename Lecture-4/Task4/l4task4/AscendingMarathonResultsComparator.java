package l4task4;

import java.util.Comparator;

public class AscendingMarathonResultsComparator implements Comparator<MarathonResult> {

    @Override
    public int compare(MarathonResult result1, MarathonResult result2) {
        return Integer.compare(result1.getTime(),(result2.getTime()));
    }
}
