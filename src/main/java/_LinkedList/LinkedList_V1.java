package _LinkedList;

public class LinkedList_V1 {
    int data;
    LinkedList_V1 next = null;

    LinkedList_V1(int data) {
        this.data = data;
    }

    public static void main(String[] args) {
        LinkedList_V1 head = new LinkedList_V1(1);
        head.addNode(2);
        head.addNode(3);
        head.addNode(4);
        head.printList();
    }

    void addNode(int data) {
        LinkedList_V1 newNode = new LinkedList_V1(data);
        LinkedList_V1 current = this;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;

    }

    void printList() {
        LinkedList_V1 current = this;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

}
