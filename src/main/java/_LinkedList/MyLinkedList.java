package _LinkedList;

public class MyLinkedList {

    Box box;

    public MyLinkedList(Box box) {
        this.box = box;
    }

    public static void main(String[] args) {
        Box b1 = new Box(1);
        Box b2 = new Box(1);
//        Box b2=new Box(3);
//        Box b3=new Box(4);
//        Box b4=new Box(2);
//        Box b5=new Box(1);
//        b1.next=b2;
//        b2.next=b3;
//        b3.next=b4;
//        b4.next=b5;
        MyLinkedList ll = new MyLinkedList(b1);
        ll.add(3);
        ll.add(6);
        ll.add(7);
        //second list
        MyLinkedList l2 = new MyLinkedList(b2);
        l2.add(4);
        l2.add(2);
        l2.add(3);
        l2.add(10);
        l2.add(11);
        //System.out.println(length(b2));
        //printList(b1);
        //System.out.println(searchItem(33,b1));
        findCommonNode(b1, b2);
    }

    static Box findCommonNode(Box l1, Box l2) {
        int length1 = length(l1);
        int length2 = length(l2);
        int gap = length2 - length1;
        if (gap < 0) {
            gap = gap * (-1);
            for (int i = 0; i < gap; i++) {
                l1 = l1.next;
            }
        } else if (gap > 0) {
            for (int i = 0; i < gap; i++) {
                l2 = l2.next;
            }
        }
        while (l1 != null && l2 != null) {
            if (l1.data == l2.data) {
                System.out.println(l1.data);
                return l1;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return null;
    }

    public static boolean searchItem(int item, Box head) {
        if (head == null) {
            return false;
        }
        Box current = head;
        while (current.next != null) {
            if (current.data == item) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public static void printList(Box head) {
        Box current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    static int length(Box l) {
        int length = 0;
        if (l == null) {
            return length;
        }
        while (l != null) {
            length++;
            l = l.next;
        }
        return length;
    }

    public void add(int value) {
        Box toAdd = new Box(value);
        Box current = this.box;
        while (current.next != null) {
            current = current.next;
        }
        current.next = toAdd;
    }

    public static class Box {
        private int data;
        private Box next;

        public Box(int data) {
            this.data = data;
        }
    }
}
