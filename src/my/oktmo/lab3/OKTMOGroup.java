package my.oktmo.lab3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class OKTMOGroup {
    private OKTMOLevel level;
    private String name;
    private long code;

    private List<OKTMOGroup> ownGroup= new ArrayList<>();
    private List<Place> places= new ArrayList<>();

    public OKTMOGroup(OKTMOLevel level, String name, long code) {
        this.level = level;
        this.name = name;
        this.code = code;
    }

    public long getCode() {
        return code;
    }

    public OKTMOLevel getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public List<OKTMOGroup> getOwnGroup() {
        return ownGroup;
    }

    public void addGroupOwnGroup(OKTMOGroup oktmoGroup) {
        ownGroup.add(oktmoGroup);
    }

    public void addPlace(Place place) {
        places.add(place);
    }

    public List<Place> getPlaces() {
        return places;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OKTMOGroup that = (OKTMOGroup) o;
        return code == that.code &&
                level == that.level &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
