package codingInterview;

import java.util.HashMap;
import java.util.Map;

public class RemoveTheDuplicateCharactersInString {

    public static void main(String[] args) {
        String name="abcdba";
        char[] str=name.toCharArray();
        removeDuplicates1(str);
        System.out.println(str);
        removeDuplicates2(str);
        String s = "abcd";
        char[][] replacements = { {'a', 'x'}, {'b', 'y'}, {'c', 'z'} };
        reverseAndReplace(s,replacements);
    }

    public static void removeDuplicates(char[] str){
        if (str == null ||str.length == 1) {
          return ;
        }
        int head=1;
        for (int i = 0; i < str.length; i++) {
           char test=str[i];
            for (int j = 1; j <  str.length; j++) {
               if(test==str[j]){

               }
            }
        }

    }

    public static void removeDuplicates1(char[] str) {
         if (str == null) return;
         int len = str.length;
         if (len < 2) return;

         int tail = 1;

         for (int i = 1; i < len; ++i) {
             int j;
             for (j = 0; j < tail; ++j) {
                 if (str[i] == str[j]) break;
                 }
             if (j == tail) {
                 str[tail] = str[i];
                 ++tail;
                 }
             }
         str[tail] = 0;
         }


    public static void removeDuplicates2(char[] str) {

        if(null==str || str.length==0)return;

        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str.length; j++) {
               if(str[i]==str[j]){
                   System.out.println(str[i]);
               }
            }
        }
    }


    public static String reverseAndReplace(String s, char[][] replacements) {
        Map<Character, Character> lookupMap= new HashMap<>();
       // lookupMap.put('a', 'x');
       // lookupMap.put('b', 'y');
      //  lookupMap.put('c', 'z');
        for (int i=0;i<replacements.length;i++) {
            lookupMap.put(replacements[i][0], replacements[i][1]);
        }

        StringBuilder result =new StringBuilder(s).reverse();
        for (int i = 0; i < result.length(); i++) {
            char current = result.charAt(i);
            if (lookupMap.containsKey(current)){
                result.setCharAt(i, lookupMap.get(current));
            }
        }

        return result.toString();
    }
















}
