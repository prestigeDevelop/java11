package _LinkedList;

public class LinkedList3 {

    private Node head;

    public <T> void add(T data){
        Node temp = new Node(data);
        if (head != null) {
            temp.next = head;
        }
        head=temp;
    }

    public <T> Object getData(){
        if (head!=null){
            Node temp = head;
            head=head.next;
            return temp.data;
        }return null;
    }

    class Node<T>{
        private T data;
        private Node<T> next;
        public Node(T data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        LinkedList3 l3 = new LinkedList3();
        l3.add(1.5);
        l3.add(2);
        l3.add(3);
        l3.add("Hello");
        System.out.println(l3.getData());
        System.out.println(l3.getData());
        System.out.println(l3.getData());
        System.out.println(l3.getData());
    }
}
