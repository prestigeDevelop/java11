package codingInterview;

import java.util.*;
import java.util.stream.Collectors;

public class ReplaceSubString {

    public static void main(String[] args) {
        //String id="aaa-456-12";
       // replace(id,123);
       // System.out.println( findFirstDuplicate("abcdefghijklmnopqrstwxyzZ"));
       // findFirstDuplicate2("aAbbccfdsdfdfsdf");
//        Map<Character,Integer> map1=new HashMap<>();
//        map1.put('a',1);
//        Map<Character,Integer> map2=new HashMap<>();
//        map2.put('b',1);
//        System.out.println(map1.equals(map2));
        //System.out.println(isAnagram("ab c","b ca"));
        System.out.println("isAnagram");
        System.out.println(isAnagram("cinema", "iceman"));
        System.out.println(isAnagram("Tom Marvolo Riddle", "I am Lord Voldemort"));
        System.out.println(isAnagram("Dave Barry", "Ray Adverb"));
        System.out.println(isAnagram("debit card", "bad credit"));
        System.out.println(isAnagram("astronomer", "Moon starer"));
        System.out.println(isAnagram("abc123", "c3b2a1"));
        System.out.println(isAnagram("abc123", "a11b22c33"));
        //////////////////////////////
        System.out.println("isAnagram 1");
        System.out.println(isAnagram1("cinema", "iceman"));
        System.out.println(isAnagram1("Tom Marvolo Riddle", "I am Lord Voldemort"));
        System.out.println(isAnagram1("Dave Barry", "Ray Adverb"));
        System.out.println(isAnagram1("debit card", "bad credit"));
        System.out.println(isAnagram1("astronomer", "Moon starer"));
        System.out.println(isAnagram1("abc123", "c3b2a1"));
        System.out.println(isAnagram1("abc123", "a11b22c33"));
        System.out.println("isAnagram 1");
        System.out.println(isAnagram1("abcd", "dbac"));//should return true
        System.out.println(isAnagram1("aabb", "bbaa")); // Correctly returns true
        System.out.println(isAnagram1("aabb", "abab")); // Should return true (valid anagram)
        System.out.println(isAnagram1("abcd", "efgh")); // Should return false (different characters, but could sum to 0!)
        System.out.println(isAnagram1("aabbcc", "aaccbb"));

    }

    private static boolean isAnagram(String phrase1, String phrase2){
        Map<Character,Integer> map1= buildMap(phrase1.toLowerCase());
        Map<Character,Integer> map2= buildMap(phrase2.toLowerCase());
       // map1.keySet().equals(map2.keySet());
        return map1.equals(map2);
    }
    private static boolean isAnagram1(String s1, String s2){
         if(s1.length()!=s2.length())return false;
        s1 = s1.replaceAll("\\s", "").toLowerCase();
        s2 = s2.replaceAll("\\s", "").toLowerCase();
         int sum=0;
        for (int i = 0; i < s1.length(); i++) {
            int index = s1.charAt(i)-'0';
            int index2 = s2.charAt(i)-'0';
            sum+=(index-index2);
        }
        return sum==0;
    }

    private static Map<Character,Integer> buildMap(String s){

        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){

            Character c=s.charAt(i);
            int ascii=(int) c;
           // System.out.println(ascii);
            if((c<97 || c>122)&&(c<48 ||c>57) ){
                continue;
            }

            if(map.containsKey(c)){
                Integer counter=map.get(c);
                map.put(c,Integer.sum(counter,1));
            }else{
                map.put(c,1);
            }

        }
//        Map<Character, Integer> charCount = s.chars().boxed().collect(Collectors.toMap(
//                k -> Character.valueOf((char) k.intValue()),
//                v -> 1,
//                Integer::sum));
        return map;
    }
    private static String replace(String id,int newDepartment){
        String result=id.substring(0,4);
        result=result+newDepartment+id.substring(7,10);
        System.out.println(result);
        return result;
    }

    private static Character findFirstDuplicate(String s){
        Set<Character> duplicates=new HashSet<>();
        duplicates.add(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if(duplicates.contains(s.charAt(i))){
                return s.charAt(i);
            }else{
                duplicates.add(s.charAt(i));
            }
        }
        return null;
    }

    private static char findFirstDuplicate2(String s){
      byte[] letters=new byte[256];

        for (int i = 0; i <s.length() ; i++) {
            int ascii= s.charAt(i);
            if(letters[ascii]==1){
                System.out.println((char) ascii);
                return (char) ascii;
            }else {
                letters[ascii] = 1;
            }
        }
        return Character.MIN_VALUE;
    }
}
