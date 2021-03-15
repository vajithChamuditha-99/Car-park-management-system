package CarParkManager;

import java.util.Comparator;

public class DateComparator implements Comparator<Vehicle> {
    @Override
    public int compare(Vehicle o1, Vehicle o2) {
        return o1.getEntryDateTime().compareTo(o2.getEntryDateTime());
    }
}

