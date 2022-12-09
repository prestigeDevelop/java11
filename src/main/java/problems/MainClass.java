package problems;

import java.io.IOException;

public class MainClass {
    public static void main(String[] args) throws IOException {
        MainClass mm = new MainClass();

//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            _LinkedList.ListNode node = _LinkedList.stringToListNode(line);
//            _LinkedList.prettyPrintLinkedList(node);
//        }
        String str = "Zzzzzzbbbccccddehhhhiii";

        byte[] bytes = str.getBytes("US-ASCII");
        // System.out.println(Arrays.toString(bytes));
        int[] countingArray = new int[128];
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            int index = (int) charArray[i];
            countingArray[index]++;
        }
        // str.chars().forEach(value -> countingArray[value]++);
        // System.out.println(Arrays.toString(countingArray));
        for (int i = 0; i < countingArray.length; i++) {
            if (countingArray[i] == 1) {
                System.out.println((char) i);
                break;
            }
        }

    }


}
