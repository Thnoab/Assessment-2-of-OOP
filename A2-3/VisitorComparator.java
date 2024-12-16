package A2;

import java.util.Comparator;

public class VisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        return v1.getName().compareTo(v2.getName());  // Sort visitors by name in ascending order
    }
}

