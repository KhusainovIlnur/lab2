package my.oktmo.lab3;

import java.util.ArrayList;
import java.util.HashSet;

public class OktmoData {
    private ArrayList<Place> places= new ArrayList();
    private HashSet<String> allStatuses = new HashSet<>();
    private ArrayList<Place> sortedPlaces;

    public void addPlace(Place place) {
        places.add(place);
    }

    public void print() {
        for (Place p: places) {
            System.out.println(p);
        }
    }

    public void printStatuses() {
        for (String i: allStatuses) {
            System.out.println(i);
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

    public ArrayList<Place> sortByName() {
        sortedPlaces = new ArrayList<>(places);
        sortedPlaces.sort(new NameComp());
        return sortedPlaces;
    }

    public ArrayList<Place> getPlaces() {
        return places;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        OktmoData that = (OktmoData) obj;
//        return places.containsAll(that.places) && allStatuses.containsAll(that.allStatuses);
//        return this.places.equals(that.places);
        for (int i = 0; i < this.places.size(); i++) {
            if ( ! this.places.get(i).equals(that.places.get(i))) { // в 3915-3918 строке были кавычки в названии, убрали
                return false;
            }
        }
        return true;

    }

    @Override
    public int hashCode() {
        return places.hashCode() + allStatuses.hashCode();
    }
}
