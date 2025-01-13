package leetCode;

import java.util.HashMap;
import java.util.Map;

public class ReverseInteger {


    public static int reverseInt(int input) {
        int temp = input;
        int result = 0;
        while (temp >= 1) {
            int mod = temp % 10;

            System.out.println(mod);

            temp = temp / 10;
            result += mod * 10;
        }

        return result;
    }



    public static void main(String[] args) {
//        System.out.println(reverseInt1(123));
//        String signalPattern ="10100";
//        for(int i=0;i<signalPattern.length();i++){
//            int current = signalPattern.charAt(i) -'0';
//            System.out.println(current);
//        }
        System.out.println(harborSignalDecoder1("1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111"));
        //System.out.println(String.valueOf((char) ('A' + 26 - 1)));

    }



    public static int reverseInt1(int input) {
        int result=0;
        while (input>0) {
            int mod = input % 10; // =3   -->>2 --> 1
            input = input / 10;//=12 --> 1 -->0
            result = result * 10 + mod;//=3,
        }
        return result;

    }

    public static String harborSignalDecoder(String signalPattern) {
        Map<Integer, String> alphabetMap = new HashMap<>();

        for (int i = 1; i <= 26; i++) {
            alphabetMap.put(i, String.valueOf((char) ('A' + i - 1)));
        }
        String result="";
        // Write code here
        int counter =0;
        for(int i=0;i<signalPattern.length();i++){
            int current = signalPattern.charAt(i) -'0';
            if(current==1){
                counter++;
            }else {
                //print(the corresponding letter)
                result+=alphabetMap.get(counter);

                result+=".";
                //print dot
                while((signalPattern.charAt(i) -'0')==0){
                    ++i;
                }
                i--;
                counter=0;
            }

        }
        if(counter>0){
            result+=alphabetMap.get(counter);
        }
        return result;
    }


    public static String harborSignalDecoder1(String signalPattern) {
//        Map<Integer, String> alphabetMap = new HashMap<>();
//
//        for (int i = 1; i <= 26; i++) {
//            alphabetMap.put(i, String.valueOf((char) ('A' + i - 1)));
//        }
        String result="";
        // Write code here
        int counter =0;
        int i=0;
        while(i<signalPattern.length() && counter<26) {
            int current = signalPattern.charAt(i) -'0';
            if(current==1){
                counter++;
            }else {
                //print(the corresponding letter)
                if(counter>0) {
                    result += String.valueOf((char) ('A' + counter - 1));
                    result += ".";
                }
                counter=0;
            }
            i++;
        }
        if(counter>0){
            result+=String.valueOf((char) ('A' + counter - 1));
        }
        return result;
    }













}
