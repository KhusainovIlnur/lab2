
package my.oktmo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class OktmoMain {

    public static void main(String[] args) {

        String filename = "data-201710.csv",
               encoding = "cp1251";

        OktmoData data = new OktmoData();
        OktmoData data2 = new OktmoData();
        OktmoReader reader = new OktmoReader();
        reader.readPlaces(filename, encoding, data); // Балезино-3 не считывается, нет статуса, 193887 строка
        reader.regExpReader(filename, encoding, data2);

/*        data.print();
        data.printStatuses();
        ArrayList<Place> sorted = data.sortByName();
        for (Place p: sorted) {
            System.out.println(p);
        }*/

        OktmoAnalyzer analyzer = new OktmoAnalyzer(data);
        ArrayList<Place> res1 = analyzer.reg1();
        ArrayList<Place> res2 = analyzer.reg2();

    }

}
