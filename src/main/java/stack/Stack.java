package stack;

public class Stack {

    private Node top;
    public <T> void push(T data){
        Node temp = new Node(data);
        temp.next=top;
        top=temp;
    }
    public <T> Object pop(){
        //null check
        if(top!=null){
        Object t = top.data;
        top=top.next;
        return t;
        }
        return null;
    }

    class Node<T>{
       private Node<T> next;
        private T data;
        public Node(T data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Stack stack =new Stack();
        //stack.push("hello1");
        //stack.push("hello2");
        //stack.push("hello3");
        for (int i = 1; i <= 6; i++) {
            stack.push("hello"+i);
        }
        for (int i = 1; i <= 6; i++) {
            System.out.println(stack.pop());
        }
        //System.out.println(stack.pop());
        //System.out.println(stack.pop());
        //System.out.println(stack.pop());
    }
}
