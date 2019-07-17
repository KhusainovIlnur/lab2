package my.oktmo;

import java.util.ArrayList;

public class OktmoData {
    private ArrayList<Place> places= new ArrayList();

    public void addPlace(Place place) {
        places.add(place);
    }

    public void print() {
        for (Place p: places) {
            System.out.println(p);
        }
    }
}
