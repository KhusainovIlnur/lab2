package my.oktmo.lab3.functional;

import java.util.List;
import java.util.ArrayList;

public class Calcurator {
    public static void main(String[] args) {

        String[] array1 = {"мама", "мыла", "раму"};
        String[] array2 = {"я", "очень", "люблю", "java"};
        String[] array3 = {"мир", "труд", "май"};

        List<String[]> arrays = new ArrayList<>();
        arrays.add(array1);
        arrays.add(array2);
        arrays.add(array3);

/*        Comparator<String[]> sortByLength = new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1.length - o2.length;
            }
        };*/

/*        Comparator<String[]> sortByWordsLength = new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                int length1 = 0;
                int length2 = 0;
                for (String s : o1) {
                    length1 += s.length();
                }
                for (String s : o2) {
                    length2 += s.length();
                }
                return length1 - length2;
            }
        };*/

        arrays.sort((o1, o2)->o1.length - o2.length);
        arrays.sort((o1, o2) -> {
            int length1 = 0;
            int length2 = 0;
            for (String s : o1) {
                length1 += s.length();
            }
            for (String s : o2) {
                length2 += s.length();
            }
            return length1-length2;
        });

        FuncInterf1 res = (int a) -> a % 13 == 0;
        FuncInterf2 res2 = (String s1, String s2) -> {
            if (s1.length() - s2.length() > 0) return s1;
            else return s2;
        };
        FuncInterf3 res3 = (a, b, c) ->{
            return Math.pow(b, 2) - 4 * a *  c;
        };
        FuncInterf3 res4 = (a, b, c) ->{
            return a * Math.pow(b, c);
        };

    }

//    public static double calculate(double a, double b, char op) {
//        return;
//    }

}
