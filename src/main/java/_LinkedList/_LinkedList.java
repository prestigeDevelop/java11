package _LinkedList;

import java.util.Hashtable;

public class _LinkedList {

    private Node head;

    public _LinkedList(Node node) {
        this.head = node;
    }

    public static void main(String[] args) {
        Node n = new Node(4);
        _LinkedList ls = new _LinkedList(n);
        ls.addNode(2);
        ls.addNode(3);
        ls.addNode(4);
        ls.addNode(4);
        ls.addNode(4);
        ls.addNode(4);
        System.out.println(ls.searchItem(4));
        ls.deleteDups(n);
        ls.printList(n);
    }

    public void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    // If we can use a buffer, we can keep track of elements in a hashtable and remove any dups:
    public void deleteDups(Node n) {
        Hashtable<Integer, Integer> table = new Hashtable();
        Node current = this.head;
        Node previos = null;
        while (current != null) {
            if (table.containsKey(current.data)) {
                //delete the node
                previos.next = current.next;
            } else {
                //add node to map
                table.put(current.data, current.data);
                previos = current;
            }
            current = current.next;
        }

    }

    void addNode(int data) {
        //Node node=new Node(data);
        Node head = this.head;
        while (head.next != null) {
            head = head.next;
        }
        head.next = new Node(data);
    }

    boolean searchItem(int item) {
        Node current = this.head;
        while (current != null) {
            if (current.data == item) {
                return true;
            } else {
                current = current.next;
            }
        }
        return false;
    }

    void printMiddle() {
        Node slow = head;
        Node fast = head;
        while (slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.data);
    }

    static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
