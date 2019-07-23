package my.oktmo.lab3;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OktmoAnalyzer {
    /*
    private OktmoData data;
    private ArrayList<Place> result = new ArrayList<>();

    public OktmoAnalyzer(OktmoData data) {
        this.data = data;
    }

    public ArrayList<Place> reg1() {
        Pattern p = Pattern.compile("^[А-Яа-я]{1,3}ово$");
        Matcher m;
        for(Place place: data.getPlaces()) {
            m = p.matcher(place.getName());
            if (m.find()) {
                result.add(place);
            }
        }
        return result;
    }

    public ArrayList<Place> reg2() {
        Pattern p = Pattern.compile("^([^аоиеёуэюяы]){1}\\w+\\1$", Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CHARACTER_CLASS);
        Matcher m;
        for(Place place: data.getPlaces()) {
            m = p.matcher(place.getName());
            if (m.find()) {
                result.add(place);
            }
        }
        return result;
    }
*/

}
