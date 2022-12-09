package codingInterview.ArraysandStrings;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class AlluniqueCharacters {

    public static void main(String[] args) {
        System.out.println(isAlUnique("gavg"));
        System.out.println(isAlUniqueMap("gavggdrefa"));
        System.out.println(removeDuplicateCharacters("ab"));
        System.out.println(CodelandUsernameValidation("_avis_hai"));
        Stream.of(charCounter("gaavggdrefa")).forEach(System.out::println);
        System.out.println(Stream.of(charCounter("gaavggdrefa")).flatMap(o -> o.values().stream()).peek(integer -> System.out.println(integer)).max(Comparator.naturalOrder()).get());
    }

    public static Map<Character, Integer> charCounter(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            int counter = 0;
            Character temp = str.charAt(i);
            if (map.containsKey(temp)) {
                //exist--update the value
                Integer bump = map.get(temp);
                bump++;
                map.replace(temp, bump);
            } else {
                //not exist yet
                map.put(temp, 1);
            }

        }
        return map;
    }

    public static boolean isAlUniqueMap(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.put(Character.valueOf(str.charAt(i)), i) != null) {
                return false;
            } else
                map.put(Character.valueOf(str.charAt(i)), i);
        }
        return true;
    }

    public static boolean isAlUnique(String str) {
        int[] hit = new int[256];
        for (int i = 0; i < str.length(); i++) {

            if (hit[str.charAt(i)] == 1) {
                return false;
            } else {
                hit[str.charAt(i)] = 1;
            }
        }
        return true;
    }


       private static String removeDuplicateCharacters(String str){
        //aaaa bbbb
           StringBuilder sb=new StringBuilder();
           for (int i = 1; i <str.length() ; i++) {
               sb.append(str.charAt(i-1));
               if (str.charAt(i - 1) == str.charAt(i) && i <= str.length()) {
                   i++;
               } else {
                   sb.append(str.charAt(i));
               }

           }

           return sb.toString();
       }

    public static String CodelandUsernameValidation(String str) {
        Predicate<String> predicate = s -> (s.length() >= 4 && s.length() <= 25);
        predicate.and(s -> s.substring(0, 1).matches("[a-zA-Z]"));
        predicate.and(s -> s.substring(1, s.length() - 1).matches("^[A-Za-z]\\w+[A-Za-z0-9]$"));
        //System.out.println(str.substring(0,1).matches("[a-zA-Z]"));
        // System.out.println(str.matches("[a-zA-Z][0-9]"));
        boolean result = predicate.test(str);


        return result == true ? str : "false";
    }
}
