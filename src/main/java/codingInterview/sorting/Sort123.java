package codingInterview.sorting;

import java.util.stream.IntStream;

public class Sort123 {

    public static void main(String[] args) {
        int[] arr = {100, 1, 2, 3, 4, 5, 6, 7, 8, 5, 5, 52, 2, 2, 2, 2, 2, 2, 54, 4, 4, 4, 74, 7, 4, 77, 4, 85, 9665, 41};
        sort(arr);
        IntStream.of(arr).forEach(item -> System.out.println(item));
    }

    private static int[] sort(int... arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                int a = arr[i];
                int b = arr[j];
                // System.out.println(a);
                // System.out.println(b);
                if (a > b) {
                    arr[i] = b;
                    arr[j] = a;
                }
            }
        }
        return arr;
    }
}
