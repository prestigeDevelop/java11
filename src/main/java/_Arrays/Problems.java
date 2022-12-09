package _Arrays;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Problems implements Cloneable {

    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        Problems p = new Problems();
        Problems p1 = new Problems();
        Map m = Collections.synchronizedMap(new LinkedHashMap());

        p1 = p;
        System.out.println(p.equals(p1));
        Problems d = (Problems) p.clone();
        findTheFirstNonRepeatingChar("Zzzzzzbbbccccddehhhhiii");
        System.out.println(isUniqueChars("aAbc"));
        int[] arr = {1, 2, 5, 6, 8, 9, 5, 0, 4, 52, 78, 41, 45, 658, 23, 5, 1, 0, 0, 69, 85, 7, 7, 1, 8};
        findCombinationToProduceSum(41, arr);
        System.out.println(isAllUniqueChar("abs"));
    }

    // Function to remove duplicate elements
    // This function returns new size of modified
    // array.
    static int[] removeDuplicates(int arr[], int n) {
        if (arr.length == 0 || arr.length == 1) {
            return arr;
        }
        int[] temp = new int[n];
        int j = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == arr[j]) {
                j++;
            }

        }
        return temp;
    }

    public static boolean isUniqueChars(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); ++i) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) return false;
            checker |= (1 << val);
        }
        return true;
    }

    private static void findCombinationToProduceSum(int number, int... arr) {

        // int result =Arrays.stream(arr).reduce(0,(left, right) ->left+ right );
        //System.out.println(result);
        //new array without duplicates
        Set<Integer> removeDuplicates = Arrays.stream(arr).collect(HashSet::new, HashSet::add, HashSet::addAll);
        Integer[] arrnew = new Integer[1];
        Integer[] array = Arrays.stream(arr).collect(HashSet::new, HashSet::add, HashSet::addAll).toArray(arrnew);
        //Set<int[]> mySet = Set.of(arr);
        //Set<Integer> mySet = new HashSet<Integer>(Arrays.asList(arr));
        Set<Integer> mySet = Arrays.stream(arr).boxed().collect(Collectors.toSet());

        //Set<Integer> mySet = new HashSet<Integer>();
        //Collections.addAll(mySet, arr);
        mySet.stream().forEach(System.out::println);
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[i] + array[j] == number) {
                    System.out.println(array[i] + " and " + array[j]);
                }
            }
        }
    }

    private static void findTheFirstNonRepeatingChar(String str) {
        int[] countingArray = new int[128];
        char[] charArray = str.toCharArray();
        System.out.println(Arrays.toString(charArray));
        for (int i = 0; i < charArray.length; i++) {
            int index = (int) charArray[i];
            countingArray[index]++;
        }
        // str.chars().forEach(value -> countingArray[value]++);
        // System.out.println(Arrays.toString(countingArray));
        for (int i = 0; i < countingArray.length; i++) {
            if (countingArray[i] == 1) {
                System.out.println((char) i);
                break;
            }
        }
    }

    private static boolean isAllUniqueChar(String str) {
        char[] temp = str.toCharArray();
        int[] helper = new int[128];

        for (int i = 0; i < temp.length; i++) {
            int index = temp[i];
            if (helper[index] == 1) {
                return false;
            } else {
                helper[index] = 1;
            }
        }
        return true;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
