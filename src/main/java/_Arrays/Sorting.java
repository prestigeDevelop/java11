package _Arrays;

import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
       // sort(new int[]{5,4,1,0,9,7});

        int[] nums ={700000000,500000000};
        sort(nums);
    }

    public static int[] sort(int[] arr){

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        return arr;
    }
/*
Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
Since the result may be very large, so you need to return a string instead of an integer.
Example 1:

Input: nums = [10,2]
Output: "210"
Example 2:

Input: nums = [3,30,34,5,9]
Output: "9534330"
 */
    public String largestNumber(int[] nums) {
        StringBuilder result = new StringBuilder();
        if(nums.length==1)return String.valueOf(nums[0]);

        String[] numStrs = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        // Sort the strings using a custom comparator
        Arrays.sort(numStrs, (a, b) -> (b + a).compareTo(a + b));
        for (String num : numStrs) {
            result.append(num);
        }
        if (result.charAt(0) == '0') {
            return "0";
        }
        return result.toString();
    }
}
