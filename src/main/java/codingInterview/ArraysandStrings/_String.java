package codingInterview.ArraysandStrings;

import java.io.Console;
import java.util.Arrays;

public class _String {

    public static void main(String[] args) {

        System.out.println(isSubString1("waterbottle", "erbottlewat"));

    }

    static void input() {
        Console console = System.console();
        if (console != null) {
            console.writer().println("Enter user and password");
            String user = console.readLine("User :");
            char[] pass = console.readPassword("Password");
            Arrays.fill(pass, 'x');

        }
    }

    //    Assume you have a method isSubstring which checks if one word is a substring of
//    another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using
//    only one call to isSubstring (i.e., "waterbottle" is a rotation of "erbottlewat").

    static boolean isSubString1(String s1, String s2) {
        char lastValue;
        StringBuilder sb = new StringBuilder(s2);
        int lastIndex = s2.length() - 1;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.equalsIgnoreCase(sb.toString())) {
                return true;
            } else {
                lastValue = sb.charAt(lastIndex);
                sb.deleteCharAt(lastIndex);
                sb.insert(0, lastValue);
                System.out.println(sb);
            }

        }
        return false;
    }

    static boolean isSubString(String s1, String s2) {
        char temp;

        char[] charArr = s2.toCharArray();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.equalsIgnoreCase(String.valueOf(charArr))) {
                return true;
            } else {
                temp = charArr[charArr.length - 1];
                for (int j = charArr.length - 1; j >= 1; j--) {
                    charArr[j] = charArr[j - 1];
                }
                charArr[0] = temp;
                System.out.println(charArr);

            }

        }
        return false;
    }
}
