package leetCode;

public class MyAtoi {

    public static void main(String[] args) {

        //System.out.println( myAtoi("-91283472332"));
        //System.out.println( myAtoi("  -0012345"));
        String str="hello";
        swapFirstLast(str);
        System.out.println( myAtoi(" "));
        String s ="50";
        int digit = s.charAt(1) - '0';
        System.out.println(digit);
        System.out.println(reverseString("abcde"));
    }
    public static String reverseString(String original) {
        // Write code here
        if(original==null || original.length()==0)return "";
        int i=original.length()-1;
        String result="";
        while(i>=0){
            result+=original.charAt(i);
            i--;
        }
        return result;
    }
    public static String swapFirstLast(String str) {
        // Write code here
        if (str.length() < 3) return str;
        if (str.charAt(0) == (str.charAt(str.length() - 1))) return str;
        char temp = str.charAt(0);
        str =str.charAt(str.length() - 1)+str.substring(1);
        str =str.substring(0,str.length() - 1)+temp;
        return str;
    }
    public static int myAtoi(String s) {
         int length=s.length();
         int i=0;
         int sign=1;
         int result=0;
         while(i<length && s.charAt(i)==' '){
             i++;
         }
        if(i<length && (s.charAt(i)=='+' || s.charAt(i)=='-')){
             sign = s.charAt(i)=='+'? 1:-1;
             i++;
         }
         while (i<length && s.charAt(i)>=48 &&s.charAt(i)<=57){
                 int digit = s.charAt(i) - '0';
             if (result > (Integer.MAX_VALUE - digit) / 10) {
                 return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
             }
                 result=result*10 +digit;
             i++;
         }
        return result*sign;
    }
}
