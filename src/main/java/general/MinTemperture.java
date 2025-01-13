package general;

import java.util.Arrays;

public class MinTemperture {

    public static void main(String[] args) {
     //   {7 5 9 1 4
        // {-10 -10} -> -10
        int[] temp=new int[]{7 ,5, 9, 1, 4};
        //temp=new int[]{-15 ,-7, -9, -14, -12};
        temp=new int[]{-10,-10};
        computeClosestToZero(temp);
    }
    public static int computeClosestToZero(int[] ts) {
        if(ts.length==0)return 0;
        Arrays.sort(ts);
        int maxNegative=ts[0];
        int minPositive =ts[ts.length-1];
        for(int i=1;i<ts.length;i++){
            if(ts[i]<0 && ts[i]>maxNegative){
                maxNegative=ts[i];
            }
            if(ts[i]>=0 && ts[i]<minPositive){
                minPositive=ts[i];
            }
        }
        if(maxNegative==minPositive){
            return minPositive;
        }else{
            int x= minPositive*(-1) >maxNegative ?minPositive:maxNegative;
            return x;
        }
        // Write your code here
        // To debug: System.err.println("Debug messages...");

    }
}
