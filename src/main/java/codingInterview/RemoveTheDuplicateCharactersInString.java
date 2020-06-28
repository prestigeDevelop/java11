package codingInterview;

public class RemoveTheDuplicateCharactersInString {

    public static void main(String[] args) {
        String name="AABBCCDDA";
        char[] str=name.toCharArray();
        removeDuplicates1(str);
        System.out.println(str);
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
}
