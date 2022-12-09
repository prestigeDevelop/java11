package leetCode;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverseInt(120));
        ;
    }

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
}
