package my.oktmo.lab3;

import java.util.Comparator;

public class NameComp implements Comparator<Place> {
    public int compare(Place p1, Place p2) {
        return p1.getName().compareTo(p2.getName());
    }
}
