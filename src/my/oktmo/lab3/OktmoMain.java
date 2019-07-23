
package my.oktmo.lab3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class OktmoMain {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        String filename = "data-201710.csv",
               encoding = "cp1251";

        OktmoData data = new OktmoData();
        OktmoReader reader = new OktmoReader();

//        reader.readPlaces(filename, encoding, data);
        reader.readPlacesFunconality(filename, encoding, data);
        data.printMOinRB();
/*        reader.regExpReader(filename, encoding, data2); // с регулярками чтение быстрее

        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("программа выполнялась " + timeSpent + " миллисекунд");


//        data.print();
//        data.printStatuses();
//        ArrayList<Place> sorted = data.sortByName();
//        for (Place p: sorted) {
//            System.out.println(p);
//        }

        OktmoAnalyzer analyzer = new OktmoAnalyzer(data);
        ArrayList<Place> res1 = analyzer.reg1();
        ArrayList<Place> res2 = analyzer.reg2();*/

    }

}
