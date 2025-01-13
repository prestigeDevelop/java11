package general;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//1. Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1
public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        //System.out.println( firstNonRepeatingChar("aabcdefgg"));
       // frequency("abcdaabgtrgt");
      //  moveZeroes(new int[]{0,1,0,3,12});
        moveZeroes1(new int[]{0,1,0,3,12});
    }
    public static int firstNonRepeatingChar(String s){
        Set<Character> set= new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            Character current =s.charAt(i);
            if(set.contains(current)){
                set.remove(current);
            }else{
                set.add(current);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            Character current = s.charAt(i);
            if(set.contains(current))return i;
        }
        return -1;
    }

    /*
    Given a string, calculate the frequency of characters in a string.
     */
    public static Map<Character,Integer> frequency(String s){
        Map<Character,Integer> freq= new HashMap<>();

        for (int i = 0; i <s.length() ; i++) {
            Character currenrt = s.charAt(i);
           // freq.compute(currenrt,(k,v)->v==null?1:v+1);

               freq.put(currenrt,freq.getOrDefault(currenrt,0)+1);
        }
        return freq;
    }
/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Input: nums = [0]
Output: [0]
 */
    public static void moveZeroes(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length-1; j++) {
                if (nums[j]==0){
                    int temp=nums[j+1];
                    nums[j+1]=0;
                    nums[j]=temp;
                }
            }
        }
    }
     //0 0 1
    public static void moveZeroes1(int[] nums) {
        int zeroCounter=0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j]!=0){
                    int temp=nums[j];
                   nums[j]=0;
                    nums[zeroCounter]=temp;
                    zeroCounter++;//2
                }
            }
    }
}
