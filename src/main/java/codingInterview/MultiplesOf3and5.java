package codingInterview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MultiplesOf3and5 {

    public static void main(String[] args) {
        multiply(10);
        String s = "dasdasdasdasz";
        //System.out.println( findLargestPrimeNumber(100));
        for (int j = 2; j <= 100; j++) {
            System.out.println(j + " : " + isPrime(j));
        }
    }

    private static int findLargestPrimeNumber(int number){
        Set<Integer> primes=new HashSet<>();
        for (int j = 2; j <= number; j++) {
            if(isPrime(j)){
                primes.add(j);
            }
        }
        return  primes.stream().max((a,b)->a.compareTo(b)).get();
    }
    private static boolean isPrime(int i) {

        for (int j = 2; j <= i; j++) {
            if (j == i) return true;
            if (i % j == 0) return false;
        }
        return true;
    }

    private static void multiply(int size) {
        List<Integer> oldList=new ArrayList<>();

        for (int i = 1; i <size ; i++) {
            if (i%3==0 ||i%5==0){
                oldList.add(i);
            }
        }
       Integer multiply=oldList.stream().mapToInt(Integer::intValue).sum();
        //OR
        multiply=oldList.stream().mapToInt(Integer::intValue).reduce(0,(a,b)->a+b);
        System.out.println(multiply);
    }
}
