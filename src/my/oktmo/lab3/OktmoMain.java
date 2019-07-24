
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

        reader.readPlacesFunconality(filename, encoding, data);
        data.printMOinRB();


    }

}
