package my.oktmo;

import java.util.ArrayList;
import java.util.HashSet;

public class OktmoData {
    private ArrayList<Place> places= new ArrayList();
    private HashSet<String> allStatuses = new HashSet<>();


    public void addPlace(Place place) {
        places.add(place);
    }

    public void print() {
        for (Place p: places) {
            System.out.println(p);
        }
    }

    public void addStatus(String status) {
        if ( ! allStatuses.contains(status)) {
            allStatuses.add(status);
        }
    }

    public Place getPlaceByIndex(int index) {
        if (index > -1 && index < places.size()) {
            return places.get(index-1);
        }
        else if (index == -1) {
            return places.get(places.size()-1);
        }
        else return null;
    }

    public int getCountOfNP(int index) {
        return places.indexOf(getPlaceByIndex(index)) + 1;
    }
}
