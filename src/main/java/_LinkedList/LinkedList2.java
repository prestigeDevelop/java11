package _LinkedList;

//Good
public class LinkedList2 {
    private int data;
    private LinkedList2 next;

    public LinkedList2(int data) {
        this.data = data;
    }

    public static LinkedList2 reverseList(LinkedList2 head) {
        LinkedList2 prev = null;

        while (head != null) {
            LinkedList2 next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        LinkedList2 root = new LinkedList2(1);
        root.addNode(2);
        root.addNode(3);
        root.addNode(4);
        for (int i = 5; i <= 1000; i++) {
            root.addNode(i);
        }
        root.printList();
        root = reverseList(root);
        root = reverseList(root);
        root.printList();
    }

    public void addNode(int data) {
        LinkedList2 current = this;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new LinkedList2(data);
    }

    public void printList() {
        LinkedList2 current = this;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

}
