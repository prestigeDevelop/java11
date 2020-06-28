package dataStrurctures;

public class LinkedList {


    public LinkedList(Node head) {
        this.head = head;
    }

    private Node head;
    int item;

    public static void main(String[] args) {
        Node head = new Node(1);
        LinkedList lkList = new LinkedList(head);
        lkList.addNode(head, 2);
        lkList.addNode(head, 3);
        lkList.addNode(head, 4);
        //  System.out.println(lkList.head.next.next.data);
        System.out.println(countNodes(head));
        System.out.println(searchItem(head, 4));

    }

    static class Node {
        public Node(int data) {
            this.data = data;
        }

        private int data;
        private Node next;
    }

    static boolean addNode(Node head, int item) {
        Node node = new Node(item);
        if (head == null) {
            head = new Node(item);
            return true;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
        return false;
    }

    static int countNodes(Node head) {
        int counter = 1;
        Node current = head;
        while (current.next != null) {
            current = current.next;
            counter++;
        }
        return counter;
    }

    static boolean searchItem(Node head, int item) {
        boolean exist = false;
        if (head == null) {
            return exist;
        }
        if (head.data == item) {
            exist = true;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data == item) {
                return true;
            }
            current = current.next;
        }
        return exist;
    }
}
