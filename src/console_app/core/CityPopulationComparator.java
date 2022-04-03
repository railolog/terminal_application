package console_app.core;

import java.util.Comparator;

public class CityPopulationComparator implements Comparator<City> {
    @Override
    public int compare(City o1, City o2) {
        return o1.compareTo(o2);
    }
}
