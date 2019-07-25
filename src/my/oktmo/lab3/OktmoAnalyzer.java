package my.oktmo.lab3;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class OktmoAnalyzer {

    public List<Place> findAllPlacesInGroup(String regionName, OktmoData data) {
        OKTMOGroup oktmoGroup = data.getOktmoGroupByRegionName(regionName);
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

    public Map<String, Long> findMostPopularPlaceName(String regionName, OktmoData data) {
        // в лист заносим все населенные пункты в регионе
        List<Place> allPlacesInRegion = findAllPlacesInGroup(regionName, data);

        // мап: название НП -> сколько раз встретилось
        Map<String, Long> resMap = allPlacesInRegion
                .stream()
                .collect(Collectors.groupingBy(p -> p.getName(), Collectors.counting()));

        // сортируем по убыванию и берем самый часто встречающийся
        Map.Entry<String, Long> mostPopularPlace = resMap.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .findFirst()
                .get();

        // возращаем мап из этого одного значения
        Map<String, Long> r = new HashMap();
        r.put(mostPopularPlace.getKey(), mostPopularPlace.getValue());

        return r;
    }

    public Map<String, Long> printStatusTableForRegion(String regionName, OktmoData data) {

        List<Place> allPlacesInRegion = findAllPlacesInGroup(regionName, data);

        // мап: группировка статус населенного пункта -> сколько раз встретилось
        Map<String, Long> resMap = allPlacesInRegion
                .stream()
                .collect(Collectors.groupingBy(p -> p.getStatus(), Collectors.counting()));

        return resMap;
    }

}
