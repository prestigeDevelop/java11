package general;

import java.util.*;

public class InputFromUser {
    public static void main(String[] args) {
        //terrestrialAnimal();
        //terrestrialAnimal1();
        Test test = new Test();

//        Arrays.stream(test.getArr()).forEach(System.out::println);
//        test.getArr()[0]="dadas";
//        Arrays.stream(test.getArr()).forEach(System.out::println);
        System.out.println(test.getName());
        test.getName().replaceFirst("a", "Z");
        System.out.println(test.getName());
        Map copy = new LinkedHashMap();
        copy.put(1, 2);
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
