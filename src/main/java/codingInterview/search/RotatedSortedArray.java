package codingInterview.search;

public class RotatedSortedArray {
    public static void main(String[] args) {
        //the binary search only apply to a sorted array
        //int[] numbers=new int[]{5,6,7,8,9,10,11,12,13,14,15,16,1,2,3,4};
        //int[] numbers=new int[]{16,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        //int[] numbers=new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        //int[] numbers=new int[]{14,15,16,3,4,5,6,7,8,9,10,11,12,13};
        //int[] numbers=new int[]{2,1};
        int[] numbers=new int[]{1,2};
        System.out.println(findTheMinimumElement(numbers));

    }

    static int findTheMinimumElement(int[] array){
        int leftIndex=0;
        int rightIndex=array.length-1;
        while (leftIndex<=rightIndex){
            int mid=leftIndex+(rightIndex-leftIndex)/2;
            System.out.println("mid= "+mid);
            //The array was not rotated
            if(array[leftIndex]<array[rightIndex]){
                return array[leftIndex];
            }
            if(mid==0){
                return array[rightIndex];
            }
            else if (array[leftIndex]>array[mid]){
                rightIndex=mid-1;
                System.out.println("rightIndex= "+rightIndex);
            }
            else{
                leftIndex=mid+1;
                System.out.println("leftIndex= "+leftIndex);
                if(array[leftIndex-1]>array[leftIndex] && array[leftIndex] <array[leftIndex+1]){
                    return array[leftIndex];
                }
            }

        }

        return 0;
    }
}
