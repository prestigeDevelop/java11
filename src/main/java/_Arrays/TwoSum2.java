package _Arrays;

import java.util.Arrays;

public class TwoSum2 {

    public static void main(String[] args) {
        int[] result = twoSum(new int[]{2, 7, 11, 15, 16, 17, 20, 25, 29, 90}, 105);
        Arrays.stream(result).forEach(System.out::println);
    }

    public static int[] twoSum(int[] numbers, int target) {
        int pointer_a = 0;
        int pointer_b = numbers.length - 1;

        while (pointer_a <= pointer_b) {
            int sum = numbers[pointer_a] + numbers[pointer_b];
            if (sum == target) {
                return new int[]{pointer_a, pointer_b};
            }
            if (sum > target) {
                pointer_b -= 1;
            } else if (sum < target) {
                pointer_a += 1;
            } else {
                return new int[]{pointer_a, pointer_b};
            }
        }
        return new int[]{};
    }
}
