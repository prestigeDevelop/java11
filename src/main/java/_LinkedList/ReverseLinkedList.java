package _LinkedList;

public class ReverseLinkedList {

    private Node listToTest;

    public ReverseLinkedList(Node node) {
        this.listToTest = node;
    }

    public static void main(String[] args) {

        ReverseLinkedList rll = new ReverseLinkedList(null);
        for (int i = 1; i < 100_000; i++) {
            rll.insert(i);
        }
        //System.out.println(rll.listToTest);
        rll.reverseList2();
        System.out.println(rll.listToTest);
        rll.prntList();
    }

    public void insert(int data) {

        if (listToTest == null) {
            listToTest = new Node(data);
        } else {
            Node current = listToTest;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(data);
        }
    }

    public void reverseList(){
        Node prev = null;
        Node current = listToTest;
        Node next;
        while (current != null){
            next = current.next;  // Save the next node
            current.next = prev;  // Reverse the current node's next pointer
            prev=current;// Move prev to the current node
             current=next;            // Move to the next node
        }
        listToTest = prev; // Update the head to the last node processed
     }

     public void prntList(){
        Node head= listToTest;
        while (head!=null){
            System.out.println(head.data);
            head=head.next;
        }
     }
    static class Node {
        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

//        @Override
//        public String toString() {
//            return "Node{" +
//                    "data=" + data +
//                    ", next=" + next +
//                    '}';
//        }
    }
    public void reverseList1(){
        Node prev=null;
        Node current = listToTest;
        Node next;
        while (current!=null){
            next=current.next;
            current.next= prev;
            prev = current;
            current = next;
        }
        listToTest=prev;
    }







    public void reverseList2(){
        Long start=System.nanoTime();
        Node prev=null;
        Node current = listToTest;
        Node next;
        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            prev.data*=2;
            current=next;
        }
        listToTest = prev;
        Long end=System.nanoTime();
        System.out.println((end-start)/  1_000_000_000.0);
    }
}
