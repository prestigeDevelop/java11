package general;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test {
    private String[] arr = new String[]{"1", "2"};
    private String name = "avishay";

    public String getName() {
        return name;
    }

    public String[] getArr() {
        return arr.clone();
    }

    public static void main(String[] args) {
         String name = "abc";
        String middle = name.substring(1,name.length()-1);
        //System.out.println(middle);
        //System.out.println(name.charAt(name.length()-1));
        StringBuilder resultString= new StringBuilder();

        resultString.append(name.charAt(name.length()-1)).append(middle).append(name.charAt(0));
       // System.out.println(resultString);

        //***********************************
        String s = "abcabcbb";
        int left=0;
        int maxLength = 0;
        Set<Character> charSet =new HashSet<>();
        for(int right=0;right<s.length();right++){
            while (charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++;
            }
            charSet.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
       // System.out.println("charSet:"+charSet);
      //  System.out.println("maxLength:"+maxLength);

        int[] arr1= {1,2,6,300,400,500};
        int[] arr2= {3,4,5,7,9,78};
        arr1= new int[]{1, 2};
        arr2= new int[]{3, 4};
        //int[] arr= {110,20,3,44,51,6,78,500};
        //System.out.println(findMin(arr));
        System.out.println(findMedianSortedArrays3(arr1,arr2));
        int x=123;
        int length=0;
        while (x>0){
            x=x/10;
            length++;
        }
        System.out.println(x);
        int type=1;
        for (int i = 0; i < length-1; i++) {
            type =type*10;
            System.out.println("the number is of :"+type);
        }
    }
    private static int findMin(int[] nums){
        int min =nums[0];
        int length = nums.length;
        for(int i=1;i<length;i++){
            if(nums[i]<min){
                min=nums[i];
            }
        }
        return min;
    }
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length+nums2.length];
        int counter=0;
        int previosMin =0;
        for(int i=0;i<nums1.length;i++){
            int[] subArray1 = Arrays.copyOfRange(nums1, i, nums1.length);
            int min1 = findMin(subArray1);
            for(int j=0;j<nums2.length;j++){
                int[] subArray2 = Arrays.copyOfRange(nums2, j, nums2.length);
                int min2 = findMin(subArray2);

                int newMin = Math.min(min1,min2);
                if(previosMin<newMin){
                    merged[counter++]=newMin;
                    previosMin=newMin;;
                    continue;
                }
            }
        }
        for(int i=0;i<merged.length;i++){
            System.out.println(merged[i]);
        }
        return 1.0;
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length+nums2.length];
        int counter=0;
        int previosMin =0;
        for(int i=0;i<nums1.length;i++){
            //int[] subArray1 = Arrays.copyOfRange(nums1, i, nums1.length);
            int[] subArray2 = Arrays.copyOfRange(nums2, i, nums2.length);
            //int min1 = findMin(subArray1);
            int min2 = findMin(subArray2);
            int newMin = Math.min(nums1[i],min2);
            if(previosMin<newMin){
                merged[counter++]=newMin;
                previosMin=newMin;;
                continue;
            }
        }
        for(int i=0;i<merged.length;i++){
            System.out.println(merged[i]);
        }
        return 1.0;
    }

    public static double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length+nums2.length];
        int counter1=0;
        int counter2=0;
        int counter3=0;
        int min1,min2;


        for(int i=0;i<merged.length;i++){
            if(counter1==nums1.length){
                for (int j = counter2; j < nums2.length; j++) {
                    merged[counter3++]=nums2[j];
                }
                break;
            }
            if(counter2==nums2.length){
                for (int j = counter1; j < nums1.length; j++) {
                    merged[counter3++]=nums1[j];
                }
                break;
            }
                min1 = nums1[counter1];
                min2= nums2[counter2];
            if(min1<min2 ){
                merged[counter3++]=min1;
                counter1++;
            }else{
                merged[counter3++]=min2;
                counter2++;
            }
        }
        for(int i=0;i<merged.length;i++){
            System.out.println(merged[i]);
        }
        if(merged.length%2==0){
            double med = merged[merged.length/2]+merged[(merged.length/2)-1];
            return med/2;
        }else{
            return merged[merged.length/2];
        }
    }
}
