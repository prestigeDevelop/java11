package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            _LinkedList.ListNode node = _LinkedList.stringToListNode(line);
            _LinkedList.prettyPrintLinkedList(node);
        }
    }

}
