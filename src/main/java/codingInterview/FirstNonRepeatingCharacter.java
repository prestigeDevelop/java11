package codingInterview;

import java.util.HashSet;
import java.util.Set;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        firstNonRepeatingCharacter();
        int []a={1,5,8,-1,-3};
        int []b={1,6,8,-9,-10};

        new FirstNonRepeatingCharacter().sumOftwoArrays(a,b,2);
//        int gg=4;
//        Integer g=4;
//        System.out.println(gg==g);
    }

    private static void firstNonRepeatingCharacter() {
        String dd="dasdasdazsdasd";
        int s= dd.lastIndexOf("a");
        for (int i = 0; i < dd.length(); i++) {
            char c=dd.charAt(i);
            int f=dd.indexOf(c);
            int e=dd.lastIndexOf(dd.charAt(i));

            if(f==e){
                System.out.println(dd.charAt(f));
                break;
            }
        }
    }

    private boolean sumOftwoArrays(int[]a,int[]b,int v){
        Set<Integer> numbersToSearchLater=new HashSet();
        for (int i = 0; i < a.length; i++) {
            numbersToSearchLater.add(v-(a[i]));
        }
        for (int i = 0; i <b.length ; i++) {
            if(numbersToSearchLater.contains(b[i])){
                System.out.println(b[i]);
                return true;
            }
        }
        return false;
    }
}
