package stack;

public class Stack2 {
    private Node top;

    public void push(Object data){
        Node temp =new Node(data);
       if (top != null){
           temp.next=top;
       }
           top=temp;
    }


    public Object pop(){
        if(top==null){
            System.out.println("Stack is empty");
            return null;
        }
        Node temp =top;
        top=top.next;
        return temp.data;
    }

    class Node{
        private Object data;
        private Node next=null;

        public Node(Object data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Stack2 st2= new Stack2();
        st2.push(1);
        st2.push(2);
        st2.push(3);
        System.out.println(st2.pop());
        System.out.println(st2.pop());
        System.out.println(st2.pop());
    }
}
