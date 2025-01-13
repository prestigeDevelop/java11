package hashMapBasedLeetCode;

import java.util.*;
import java.util.stream.Collectors;

public class Problems {
    public static void main(String[] args) {
        int[] nums = { 7, 11, 15,2};
        int target = 9;
        //Output: [0, 1]
        //Explanation: nums[0] + nums[1] = 2 + 7 = 9
        twoSum(nums,target);
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(input);
        System.out.println(result);
        int[] arr = {1,1,1,2,2,3,3,3,3,3,};
        topKFrequentElements(arr,2);
    }
/*
Input: nums = [2, 7, 11, 15], target = 9
Output: [0, 1]
Explanation: nums[0] + nums[1] = 2 + 7 = 9
 */
    private static int[] twoSum(int[] arr ,int target){
        Map<Integer,Integer> map = new LinkedHashMap();
        for (int i = 0; i < arr.length; i++) {
            Integer key = target-arr[i];
            //i=1
            //9-7=2
            if(map.containsKey(key)){
                int[] result =  new int[]{map.get(key), i};
                return result;
            }
            // Store the value and index in the map
            map.put(arr[i], i);
            //i=0
            //2,0
            //
        }
        return arr;
    }
/*
Longest Substring Without Repeating Characters (Medium)
Problem:
Given a string s, find the length of the longest substring without repeating characters.
Input: s = "abcabcbb"
Output: 3
Explanation: The longest substring is "abc", with a length of 3.
 */
public static int lengthOfLongestSubstring(String s) {
    int left = 0, maxLen = 0;
    Set<Character> set = new HashSet<>();

    for (int right = 0; right < s.length(); right++) {
        char c = s.charAt(right);
        while (set.contains(c)) {
            set.remove(s.charAt(left));
            left++;
        }
        set.add(c);
        maxLen = Math.max(maxLen, right - left + 1);
    }
    return maxLen;
}
    public static int lengthOfLongestSubstring1(String s) {
        int left = 0, maxLength = 0;
        HashMap<Character, Integer> map = new HashMap<>(); // Character → Index

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If the character already exists, "jump" the left pointer
            if (map.containsKey(currentChar)) {
                left = Math.max(left, map.get(currentChar) + 1);
            }

            // Update the character's latest index
            map.put(currentChar, right);

            // Update the max length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static int maxSum(int[] arr, int k) {

    return 0;
    }

    /*
    Group Anagrams
    Input: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
    Output: [["bat"], ["nat", "tan"], ["ate", "eat", "tea"]]
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        // Method implementation goes here
        Map<String,List<String>> map = new HashMap<>();
        for (String word:strs){
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
             String sorted = new String(chars);
            map.compute(sorted,(k,v)->{
                if (v==null){
                    v = new ArrayList<>();
                    v.add(word);
                }else{
                    v.add(word);
                }
                return v;
            });
            //SAME CODE
//             if(map.containsKey(sorted)){
//                 map.get(sorted).add(word);
//             }else{
//                 List list =  new ArrayList<String>();
//                 list.add(word);
//                 map.put(sorted,list);
//             }
        }
        return map.values().stream().collect(Collectors.toList());
    }
    public static List topKFrequentElements(int[] arr , int k){
        Map<Integer,Integer> map = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
             Integer key= arr[i];
             map.put(key,map.getOrDefault(key,0)+1);
        }
        LinkedHashMap<Integer,Integer> sortedMap = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue()) // Sort based on values
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, // Handle duplicate values (not relevant here)
                        LinkedHashMap::new // Maintain insertion order
                ));

        // Print the sorted map
        sortedMap.forEach((key, value) -> System.out.println("(" + key + ", " + value + ")"));

      //  List<Integer> topK = new ArrayList<>(sortedMap.keySet());
        List<Integer> topK = sortedMap.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue())) // Sort by value descending
                .map(Map.Entry::getKey) // Extract the keys
                .limit(k) // Limit to top k elements
                .collect(Collectors.toList());
        Collections.reverse(topK);
        return topK;

    }
}


