package leetCode;

public class ReverseNumber {


    public static int reverse(int x) {

        int length=0;

        System.out.println(x);
        boolean isNegative = x<0 ?true:false;
        if(isNegative)x*=(-1);
        int temp=x;
        while (temp>0){
            length++;
            temp=temp/10;
        }

        int type=1;
        for (int i = 0; i < length-1; i++) {
            type =type*10;
        }

        int res=0;
        while (x>=1){
            int mod =x%10;
            x=x/10;
            if (mod > Integer.MAX_VALUE / type) {
                System.out.println("Multiplication will overflow a 32-bit signed integer.");
                return 0;
            }
            res+=mod*type;
            type=type/10;
        }

        if(isNegative)return res*(-1);

        return res;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
    }
}
