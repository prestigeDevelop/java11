package general;

import lombok.Data;
import lombok.Getter;


public class Singelton {

    private static Singelton instance;

    @Getter
    private int age;
    @Getter
    private String name;

    private Singelton(int age,String name){
        this.age=age;
        this.name=name;
    }

    public static Singelton getInstance(int age,String name){
        if (instance==null){
            instance = new Singelton(age,name);
        }
        return instance;
    }

    public static void main(String[] args) {
        Singelton s = Singelton.getInstance(4,"abc");

        s = Singelton.getInstance(5,"bbbb");

        s = Singelton.getInstance(6,"ccccc");
        s = Singelton.getInstance(7,"ddddd");
    }
}
