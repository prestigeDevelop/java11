package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Permutations {
    //[1,2,3]
    private int x;

    public Permutations(int x) {
        this.x = x;
    }

    public static List<List<Integer>> permute(int[] nums) {
        if (nums.length == 1) return new ArrayList(Arrays.asList(nums));
        else {
            List<List<Integer>> result = new ArrayList();
            int size = nums.length;
            int numberOfPermutations = getNumberOfPermutations(size);
            for (int i = 0; i < numberOfPermutations; i++) {
                //result.add(new ArrayList<Integer>());
                for (int j = 0; j < nums.length; j++) {
                    System.out.println(nums[j * i]);

                }
            }
            System.out.println(result);
            return null;
        }
    }

    private static int getNumberOfPermutations(int size) {
        if (size == 0) return 1;
        else
            return size * getNumberOfPermutations(size - 1);


    }

    public static void main(String[] args) {
        Permutations Permutations1 = new Permutations(5);
        Permutations Permutations2 = new Permutations(5);
        System.out.println(Permutations1.equals(Permutations2));
        System.out.println(1 + " " + 1);
        int[] nums = {1, 2, 3};
        // Permutations.permute(nums);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Permutations that = (Permutations) o;
        return x == that.x;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x);
    }
}
