package my.oktmo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class OktmoReader {

/*    private String clearStr(String... dirtyString) {
        if (dirtyString.length > 1) {
            ArrayList<String> returnable = new ArrayList<>();
        }
        return dirtyString.replace("\"","");
        return
    }*/

    private String replaceLimiter = "\"";
    private String replaceOn = "";

    public void readPlaces(String filename, String encoding, OktmoData data) {
        int lineCount=0;
        try (
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(filename),
                                encoding
                        )
                )
        ) {
            // пропуск первых двух ненужных строк
            br.readLine();
            br.readLine();

            String s;
//            ArrayList<String> splitStr = new ArrayList<String>();
            String[] splitStr;
            String code, name, status;
            while ((s=br.readLine()) !=null ) { // пока readLine() возвращает не null
                lineCount++;

                splitStr = s.split(";");
                // индексы, которые необходимо очистить
                int[] clearArray = {0, 1, 2, 3, 5, 6};
                for (int i: clearArray) {
                    splitStr[i] = splitStr[i].replace(replaceLimiter, replaceOn);
                }

                if (splitStr[5].equals("2") && ! splitStr[6].startsWith("Населенные пункты") ) {

                    code = splitStr[0] + splitStr[1] + splitStr[2] + splitStr[3];
                    Long.parseLong(code);

                    if (splitStr[6].indexOf(" ") != -1) {
                        int split = splitStr[6].indexOf(" ");
                        status = splitStr[6].substring(0, split);
                        name = splitStr[6].substring(split + 1);
                    }
                    else {
                        status = "undefined";
                        name = splitStr[6];
                    }

                    Place place = new Place(Long.parseLong(code), status, name);
                    data.addPlace(place);
//                    System.out.println(place);
                }





                if (lineCount==20) break; // пример частичного чтения первых 20 строк

            }
//            System.out.println();
        }
        catch (IOException ex) {
            System.out.println("Reading error in line "+lineCount);
            ex.printStackTrace();
        }

}
 
}
