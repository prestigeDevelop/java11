package codingInterview;

import java.util.HashMap;
import java.util.Map;

public class FileNamesUnique {

//Leetcode Challenge
    public static void main(String[] args) {
        // String[] names={"gta","gta(1)","gta","avalon"};
        String[] names = {"onepiece", "onepiece(1)", "onepiece(2)", "onepiece(3)", "onepiece"};
        unique(names);
        ///Output: ["gta","gta(1)","gta(2)","avalon"]
        // ["onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece(4)"]
    }

    public static String[] unique(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            if (map.containsKey(names[i])) {
                int computedValue = map.computeIfPresent(names[i], (v, c) -> c + 1);

                String newKeyToPut = names[i].concat("(" + computedValue + ")");
                if (map.containsKey(newKeyToPut)) {
                    int value = Integer.valueOf(newKeyToPut.substring(newKeyToPut.length() - 2, newKeyToPut.length() - 1));
                    int x=value;
                    while(map.containsKey(names[i].concat("(" + i + ")"))){
                        i++;
                    }
                    map.put(names[i].concat("(" + i + ")"), computedValue);
                    names[i] = names[i].concat("(" + i + ")");
                } else {
                    map.put(names[i].concat("(" + computedValue + ")"), computedValue);
                    names[i] = names[i].concat("(" + computedValue + ")");
                }

            } else {
                int initValue = map.computeIfAbsent(names[i], s -> 1);
                // map.put(names[i].concat("("+initValue+")"),initValue);
            }
        }
        return names;
    }
}
