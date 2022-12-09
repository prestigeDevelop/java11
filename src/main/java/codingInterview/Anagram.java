package codingInterview;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Anagram {
    public static void main(String[] args) {
        // Test t=new Test();
        String s = "Elbowc";
        String t = "BelowC";
        System.out.println(anagram(s, t));
    }

    static boolean anagram(String s, String t) {
// ****************first solution
        s = s.toLowerCase();
        t = t.toLowerCase();
        List<String> ss1 = new ArrayList<>();
        for (Character c : s.toCharArray()) {
            ss1.add(String.valueOf(c));
        }
        List<String> ss2 = new ArrayList<>();
        for (Character c : s.toCharArray()) {
            ss2.add(String.valueOf(c));
        }

        ss1.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        ss1.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        //return ss1.equals(ss2);
        // ****************Second solution
        char[] s1 = s.toCharArray();
        int first = asciiCounter(s1);
        int second = asciiCounter(t.toCharArray());

        return first == second;
    }

    static int asciiCounter(char[] s) {
        int sum = 0;
        for (char c : s) {
            sum += c;
        }

        return sum;
    }

}
