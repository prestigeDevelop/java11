package leetCode;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class WordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {

        for (String word:wordDict){
            if(s.contains(word)){
                String minimunSubString=word;
                int i=0;
                while(i<wordDict.size()){
                    if(s.contains(wordDict.get(i)) && wordDict.get(i).length()<minimunSubString.length() ){
                        minimunSubString=wordDict.get(i);
                    }
                    i++;
                }
                s=s.replace(minimunSubString,"");
                wordDict.remove(minimunSubString);
                if(s.length()==0)return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //String s="cars";
        //List<String> wordDict= Arrays.asList("ca","rs");
        String s="applepenapple";
        List<String> wordDict= Arrays.asList("apple","pen");
       System.out.println(wordBreak1(s,wordDict));
    }


    public static boolean wordBreak1(String s, List<String> wordDict) {
//        for (int i = 0; i < ; i++) {
//
//        }
        return false;
    }
}
