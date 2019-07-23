package my.oktmo.lab3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OKTMOGroup {
    private OKTMOLevel level;
    private String name;
    private long code;

    private List<OKTMOGroup> ownGroup= new ArrayList<>();

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
}
