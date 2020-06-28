package codingInterview.ArraysandStrings;

public class AlluniqueCharacters {

    public static void main(String[] args) {
        System.out.println(isAlUnique("gavg"));
        System.out.println(removeDuplicateCharacters("ab"));
    }

    public static boolean isAlUnique(String str){
       int[] hit=new int[256];
        for (int i = 0; i <str.length() ; i++) {

            if(hit[str.charAt(i)]==1){
                return false;
            }else{
                hit[str.charAt(i)]=1;
            }
        }
        return true;
    }


       private static String removeDuplicateCharacters(String str){
        //aaaa bbbb
           StringBuilder sb=new StringBuilder();
           for (int i = 1; i <str.length() ; i++) {
               sb.append(str.charAt(i-1));
               if(str.charAt(i-1)==str.charAt(i) && i<=str.length()){
                   i++;
               }else{
                   sb.append(str.charAt(i));
               }

           }

        return sb.toString();
       }
}
