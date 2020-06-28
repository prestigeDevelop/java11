package general;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.function.Predicate;

public class InputFromUser {
    public static void main(String[] args) {
        terrestrialAnimal();
        terrestrialAnimal1();
    }

    private static void terrestrialAnimal() {
        Scanner myo2=new Scanner(System.in);
        int choice=0;
        List<String> list=new ArrayList<>();
        
        if(myo2.hasNextInt()) {
            //System.out.println("nextInt:"+myo2.nextInt());
            choice = myo2.nextInt();
            try {
                System.out.println(choice);
            }finally {
                System.out.println(choice);
            }
            boolean bool=myo2.nextBoolean();
            System.out.println(bool);
            myo2.nextLine();
        }
        myo2.close();

    }

    private static void terrestrialAnimal1() {
        Scanner myo1=new Scanner(System.in);
        int choice=0;

        if(myo1.hasNextInt()) {
            //System.out.println("nextInt:"+myo2.nextInt());
            choice = myo1.nextInt();
            System.out.println(choice);
            choice = myo1.nextInt();
            System.out.println(choice);
            choice = myo1.nextInt();
            System.out.println(choice);
        }
        myo1.close();

    }
}
