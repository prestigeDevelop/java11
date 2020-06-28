package codingInterview;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Anagram {
    public static void main(String[] args) {
    String s="bac";
    String t="cba";
        System.out.println(anagram(s,t));
    }

    static boolean anagram(String s, String t) {

        return sort(s).equals(sort(t));
    }

    static String sort(String s){
        char[] str=s.toCharArray();
        Arrays.sort(str);
        return new String(str).toLowerCase();
    }
}
