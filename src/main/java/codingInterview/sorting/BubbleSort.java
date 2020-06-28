package codingInterview.sorting;

public class BubbleSort {
    public static void main(String[] args) {
        int [] array=new int[]{5,3,8,4,2,1,3,5,8};
        boolean flag=true;
        int y = 0;
        int k = 0;

            while( y < array.length) {
                for (int j = 0; j < array.length - 1; j++) {
                    // int j = i + 1;
                    if (array[j] > array[j+1]) {
                        int temp = array[j];
                        array[j] = array[j+1];
                        array[j+1] = temp;

                    }
                }
                y++;
            }

        for (int m = 0; m <array.length ; m++) {
            System.out.println(array[m]);
        }
    }
}
