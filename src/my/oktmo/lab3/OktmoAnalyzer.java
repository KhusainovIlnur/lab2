package my.oktmo.lab3;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class OktmoAnalyzer {

    public List<Place> findAllPlacesInGroup(OKTMOGroup oktmoGroup, OktmoData data) {
        if (oktmoGroup.getLevel() == OKTMOLevel.REGION)
            return data.getDataMap().get(oktmoGroup.getCode()).getOwnGroup()
                    .stream()
                    .flatMap(og -> og.getOwnGroup().stream())
                    .flatMap(og -> og.getPlaces().stream())
                    .collect(Collectors.toList());

        if (oktmoGroup.getLevel() == OKTMOLevel.RAYON)
            return data.getDataMap().get(oktmoGroup.getCode()).getOwnGroup()
                .stream()
                .flatMap(og -> og.getPlaces().stream())
                .collect(Collectors.toList());

        if (oktmoGroup.getLevel() == OKTMOLevel.SELSOVET)
            return data.getDataMap().get(oktmoGroup.getCode()).getPlaces()
                .stream()
                .collect(Collectors.toList());
        return Collections.emptyList();
    }

}
