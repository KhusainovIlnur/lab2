
package my.oktmo.lab3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public class OktmoMain {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        String filename = "data-201710.csv",
               encoding = "cp1251";

        OktmoData data = new OktmoData();
        OktmoReader reader = new OktmoReader();

        reader.readPlacesFunconality(filename, encoding, data);
        OktmoAnalyzer analyzer = new OktmoAnalyzer();

/*
        OKTMOGroup
                aksSelsovet = new OKTMOGroup(OKTMOLevel.SELSOVET, "Аксеновский сельсовет", 80602406000L),
                alshRayon   = new OKTMOGroup(OKTMOLevel.RAYON, "Альшеевский муниципальный район", 80602000000L),
                rbRegion    = new OKTMOGroup(OKTMOLevel.REGION, "Муниципальные образования Республики Башкортостан", 80000000000L);

        List<Place> resS = analyzer.findAllPlacesInGroup(aksSelsovet, data);
        List<Place> resRayon = analyzer.findAllPlacesInGroup(alshRayon, data);
        List<Place> resRegion = analyzer.findAllPlacesInGroup(rbRegion, data);
 */

        List<Place> resRegion = analyzer.findAllPlacesInGroup("Муниципальные образования Республики Башкортостан", data);
//        List<Place> resRegion = analyzer.findAllPlacesInGroup("Муниципальные образования Республики Татарстан (Татарстана)", data);

        Map<String, Long> mostPopularResult = analyzer.findMostPopularPlaceName("Муниципальные образования Республики Башкортостан", data);
//        Map<String, Long> mostPopularResult = analyzer.findMostPopularPlaceName("Муниципальные образования Республики Татарстан (Татарстана)", data);

        Map<String, Long> statusMapForRegion = analyzer.printStatusTableForRegion("Муниципальные образования Республики Башкортостан", data);
//        Map<String, Long> statusMapForRegion = analyzer.printStatusTableForRegion("Муниципальные образования Республики Татарстан (Татарстана)", data);

        System.out.println();
    }
}
