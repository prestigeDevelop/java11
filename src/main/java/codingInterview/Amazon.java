package codingInterview;

import java.util.*;

public class Amazon {

    public static void main(String[] args) {
        System.out.println(compress("aaabbbabcca"));


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
