package my.oktmo.lab3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
        )
        {
/*            ArrayList<String> ignoreStrStartWith = new ArrayList<>(Arrays.asList(
                    "Раздел 1. Муниципальные образования",
                    "Раздел 2. Населенные пункты",
                    "Населенные пункты, входящие в состав",
                    "Городские поселения",
                    "Межселенные территории"
            ));*/

            String ignoreStrStartWith = "" +  // для удобства начато с новой строки
                    "Раздел 1. Муниципальные образования" + "|" +
                    "Раздел 2. Населенные пункты" + "|" +
                    "Муниципальные районы" + "|" +
                    "Населенные пункты, входящие в состав" + "|" +
                    "Сельские поселения" + "|" +
                    "Городские поселения" + "|" +
                    "Межселенные территории";

            String  regionPattern = "^" +  // начало регулярного выражения
                                    // 1 столбец
                    "\"(\\d{2})\";" +
                                    // 2 столбец, признак региона
                    "\"(000)\";"    +
                                    // 3 столбец, признак региона
                    "\"(000)\";"    +
                                    // 4 столбец, признак региона
                    "\"(000)\";"    +
                                    // 5 столбец
                    "\"(\\d{1})\";" +
                                    // 6 столбец
                    "\"(\\d{1})\";" +
                                    // 7 столбец, название группы, весь столбец целиком, кроме строк в ignoreStrStartWith, используется негативное заглядывание вперед
                    "\"(?!" + ignoreStrStartWith + ")(.*?)\";" +
                                    // конец рег. выражения
                    ".*";

            String  rayonPattern = "^" +  // начало регулярного выражения
                                    // 1 столбец
                    "\"(\\d{2})\";" +
                                    // 2 столбец
                    "\"(\\d\\d[1-9])\";" +
                                    // 3 столбец, признак района
                    "\"(000)\";"    +
                                    // 4 столбец, признак района
                    "\"(000)\";"    +
                                    // 5 столбец
                    "\"(\\d{1})\";" +
                                    // 6 столбец
                    "\"(\\d{1})\";" +
                                    // 7 столбец, название группы, весь столбец целиком, кроме строк в ignoreStrStartWith, используется негативное заглядывание вперед
                    "\"(?!" + ignoreStrStartWith + ")(.*?)\";" +
                                    // конец рег. выражения
                    ".*";

            String  selsovetPattern = "^" +  // начало регулярного выражения
                    // 1 столбец
                    "\"(\\d{2})\";" +
                    // 2 столбец
                    "\"(\\d{3})\";" +
                    // 3 столбец
                    "\"(\\d\\d[1-9])\";"    +
                    // 4 столбец, признак сельсовета
                    "\"(000)\";"    +
                    // 5 столбец
                    "\"(\\d{1})\";" +
                    // 6 столбец
                    "\"(\\d{1})\";" +
                    // 7 столбец, название группы, весь столбец целиком, кроме строк в ignoreStrStartWith, используется негативное заглядывание вперед
                    "\"(?!" + ignoreStrStartWith + ")(.*?)\";" +
                    // конец рег. выражения
                    ".*";

            String s;
            Pattern p = Pattern.compile(regionPattern, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CHARACTER_CLASS);
            Matcher m;
            String code, name, status;

            while ((s=br.readLine()) !=null ) { // пока readLine() возвращает не null
                lineCount++;
                if (lineCount == 3) {
                    System.out.println();
                }
                m = p.matcher(s);
                if (m.find()) {
                    System.out.println(s);
                    code = m.group(1) + m.group(2) + m.group(3) + m.group(4);
                    status = "";
                    name = "";
                }

//                if (lineCount==20) break; // пример частичного чтения первых 20 строк
            }
            System.out.println();
        }
        catch (IOException ex) {
            System.out.println("Reading error in line "+lineCount);
            ex.printStackTrace();
        }
    }

//  Pattern.compile("\"(?!Раздел 1. Муниципальные образования|Раздел 2. Населенные пункты|Населенные пункты, входящие в состав|Городские поселения|Межселенные территории)(.*?)\";", Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CHARACTER_CLASS).matcher("\"Раздел 1. Муниципальные образования субъектов Российской Федерации\";").find()
//  Pattern.compile("\"(?!Раздел 1. Муниципальные образования|Раздел 2. Населенные пункты|Населенные пункты, входящие в состав|Городские поселения|Межселенные территории)(.*?)\";", Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CHARACTER_CLASS).matcher("\"Муниципальные образования Алтайского края\";").find()

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
