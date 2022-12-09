package leetCode;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static List<List<Long>> generate(int numRows) {//3
        List<List<Long>> result = new ArrayList<>();
        //create the first row
        List<Long> l1 = new ArrayList<>();
        l1.add(1l);
        result.add(l1);

        for (int i = 1; i < numRows; i++) {
            List<Long> next = new ArrayList<>(1);
            next.add(0, 1l);
            for (int k = 1; k < i; k++) {
                Long left = result.get(i - 1).get(k - 1);
                Long right = result.get(i - 1).get(k);
                next.add(k, left + right);
            }
            next.add(1l);
            result.add(next);
        }

        return result;
    }

    public static void main(String[] args) {
        generate(50).stream().forEach(i -> System.out.println(i));
        Integer x = 1000000000;
        Long y = 100000000000000000l;
        Double z = 100000000000000000.0;
        Number v = 1000000000;
    }
}
