package codingInterview;

import java.util.*;

public class Amazon {

    public static void main(String[] args) {
        System.out.println(compress2("bcca"));
        System.out.println(compress2("aaabbbabcca"));
        System.out.println(compress2("abc"));
        System.out.println(compress2("zzz"));
    }
   //I like this best
    private static String compress2(String input) {

        StringBuilder sb = new StringBuilder();
        int counter = 0;
        int left = 0;
        int right=0;
        for (int i = 0; i < input.length(); i++) {
            right=i;
          if(input.charAt(left)==input.charAt(i)){
              counter++;
          }else {
              sb.append(counter).append(input.charAt(left));
              counter = 0;
              left = i;
              i--;
          }
        }
        sb.append(counter).append(input.charAt(right));
        return sb.toString();
    }
// a b c
    private static String compress1(String input){

        StringBuilder sb= new StringBuilder();
        int counter =1;
        int left=0;
        for (int right =1; right < input.length(); right++) {
            while ( input.charAt(right)==input.charAt(left) ){
                right++;
                left++;
                counter++;
                if(right==input.length())break;
            }
            sb.append(counter).append(input.charAt(left));
            left++;
            counter=1;
            if(right==input.length()-1){
                sb.append(counter).append(input.charAt(right));
            }
        }



        return sb.toString();
    }



















    private static String compress(String input){
          //aaa bbb

        StringBuilder sb=new StringBuilder();
        int counter=1;
        Character current=null;
        Character previous=null;
        for (int i = 1; i < input.length(); i++) {
           current=input.charAt(i);
            previous=input.charAt(i-1);
            if(current.equals(previous)){
                counter++;
            }else{
                sb.append(counter).append(previous);
                counter=1;
            }

        }
        sb.append(counter).append(current);
        return sb.toString();
    }
}
