package my.oktmo.lab3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OktmoReader {
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
                    data.addStatus(status);
//                    System.out.println(place);
                }

//                if (lineCount==20) break; // пример частичного чтения первых 20 строк
            }
//            System.out.println();
        }
        catch (IOException ex) {
            System.out.println("Reading error in line "+lineCount);
            ex.printStackTrace();
        }
    }

    public void regExpReader(String filename, String encoding, OktmoData data) {
        int lineCount=0;
        try (
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(filename),
                                encoding
                        )
                )
        )
        {
            // пропуск первых двух ненужных строк
            br.readLine();
            br.readLine();

            String s;

            String  // 1 столбец
                    c1 = "\"(\\d{2})\";",
                    // 2 столбец
                    c2 = "\"(\\d{3})\";",
                    // 3 столбец
                    c3 = "\"(\\d{3})\";",
                    // 4 столбец
                    c4 = "\"(\\d{3})\";",
                    // 5 столбец
                    c5 = "\"(\\d{1})\";",
                    // 6 столбец
                    c6 = "\"(2)\";",
                    // 7 столбец, название населенного пункта, вместе со статусом, используется негативное заглядывание вперед
                    c7 = "\"(?!Населенные пункты)(.*?) (.+?)\";";

            String regexp = "^" + c1 + c2 + c3 + c4 + c5 + c6 + c7 + ".*";
            Pattern p = Pattern.compile(regexp, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CHARACTER_CLASS);
//            Pattern p = Pattern.compile("^\"(\\d{2})\";\"(\\d{3})\";\"(\\d{3})\";\"(\\d{3})\";\"(\\d{1})\";\"(2)\";\"(?!Населенные пункты)(.*?) (.+?)\";.*", Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CHARACTER_CLASS);
            Matcher m;
            String code, name, status;

            while ((s=br.readLine()) !=null ) { // пока readLine() возвращает не null
                lineCount++;
                m = p.matcher(s);
                if (m.find()) {
                    code = m.group(1) + m.group(2) + m.group(3) + m.group(4);
                    status = m.group(7);
                    name = m.group(8);

                    Place place = new Place(Long.parseLong(code), status, name);
                    data.addPlace(place);
                    data.addStatus(status);
                }

//                if (lineCount==20) break; // пример частичного чтения первых 20 строк
            }
        }
        catch (IOException ex) {
            System.out.println("Reading error in line "+lineCount);
            ex.printStackTrace();
        }
    }

 
}
