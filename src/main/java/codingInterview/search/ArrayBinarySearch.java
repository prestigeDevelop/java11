package codingInterview.search;

public class ArrayBinarySearch {
    public static void main(String[] args) {
        //the binary search only apply to a sorted array
       int[] numbers=new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        System.out.println(searchElement(numbers,15));

    }

    static int searchElement(int[] array,int item){
        int leftIndex=0;
        int rightIndex=array.length-1;
       while (leftIndex<=rightIndex){
           int mid=leftIndex+(rightIndex-leftIndex)/2;
           //System.out.println("mid= "+mid);
           if(array[mid]==item){
               return array[mid];
           }else if (array[mid]>item){
               rightIndex=mid-1;
               System.out.println("rightIndex= "+rightIndex);
           }else{
               leftIndex=mid+1;
               //System.out.println("leftIndex= "+leftIndex);
           }

       }




        return 0;
    }
}
