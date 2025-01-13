package dataStrurctures;

public class Main {
    public static void main(String[] args) {
        System.out.println(reverse1("ABCD"));;

    }
    public static String reverse(String original) {
        char[] chars =original.toCharArray();
        int x=1;
        for(int i=0;i<chars.length;i++){
            int rightIndex=chars.length-x;
           if (rightIndex>=i) {
               char right = chars[rightIndex];
               char left = chars[i];
               chars[i]=right;
               chars[rightIndex]=left;
               x++;
           }else {
               break;
           }
        }
        return  new String(chars);
    }

    public static String reverse1(String original) {
        if (original == null || original.isEmpty()) {
            return original;
        }
        char[] chars = original.toCharArray();
        int left=0;
        int right = chars.length-1;
        while (right>=left){
            char temp=chars[left];
            chars[left]=chars[right];
            chars[right]=temp;
            left++;
            right--;
        }
        return  new String(chars);
    }

    private static int reverseNumber(int x){
        x= x/10;

        return 0;
    }
}
