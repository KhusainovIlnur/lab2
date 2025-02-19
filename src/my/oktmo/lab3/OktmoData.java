package my.oktmo.lab3;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class OktmoData {
/*    private ArrayList<Place> places= new ArrayList();
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
    }*/

//    private HashMap<Long, OKTMOGroup> dataMap = new HashMap<>();
    private TreeMap<Long, OKTMOGroup> dataMap = new TreeMap<>(new Comparator<Long>() {
        @Override
        public int compare(Long o1, Long o2) {
            return o1.compareTo(o2);
        }
    });

    private TreeMap<String, OKTMOGroup> nameObjMap = new TreeMap<>();

    public OKTMOGroup getOktmoGroupByRegionName(String regionName) {
        return nameObjMap.get(regionName);
    }

    public void addToNameObjMap(String name, OKTMOGroup oktmoGroup) {
        nameObjMap.put(name, oktmoGroup);
    }

    public void addGroup(OKTMOGroup oktmoGroup) {
        dataMap.put(oktmoGroup.getCode(), oktmoGroup);

    }

    public TreeMap<Long, OKTMOGroup> getDataMap() {
        return dataMap;
    }

    public void printMOinRB() {
        dataMap.get(80000000000L).getOwnGroup().forEach(og -> System.out.println(og.getName()));
    }

    public int getCountMOinRB() {
        return dataMap.get(80000000000L).getOwnGroup().size();
    }

    public int getCountSelsovetInRBRayon(long code) {
        return  dataMap.get(80000000000L).getOwnGroup().stream().filter(og -> og.getCode() == code).limit(1).mapToInt(og -> og.getOwnGroup().size()).sum();
    }
}
