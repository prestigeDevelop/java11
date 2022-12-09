package leetCode;

import java.util.Arrays;

public class ContainsDuplicates {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 3, 4, 56, 8, 8};
        // System.out.println(hasDuplicates(arr));
        System.out.println(hasDuplicates1(arr));
        System.out.println(hasDuplicates2(arr));
    }

    public static boolean hasDuplicates2(int[] arr) {

        long result = Arrays.stream(arr).distinct().peek(i -> System.out.println(i)).count();

        return !(result == arr.length);
    }

    public static boolean hasDuplicates1(int[] arr) {
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 1; i++) {
            System.out.println(arr[i + 1]);
            if (arr[i] == arr[i + 1]) {

                return true;
            }
        }
        return false;
    }

    public static boolean hasDuplicates(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int counter = 0;
            for (int j = 0; j < arr.length; j++) {
                //System.out.println(j);
                if (arr[i] == arr[j]) {
                    counter++;
                    if (counter == 2) return true;
                }
            }
        }
        return false;
    }
}
