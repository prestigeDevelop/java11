package stack;

public class Stack1 {
    private Node top;

    public void push(Object data){
        Node temp = new Node(data);
        if (top != null) {
            temp.next = top;
        }
        top=temp;
    }

    public Object pop(){
        if (top==null)return null;
        Node temp =top;
        top=top.next;
        return temp.data;
    }

    public Integer count(Node top){
        Long start =System.nanoTime();
        int counter=0;
        if(top!=null){
            counter++;
            while (top.next!=null){
                counter++;
                top=top.next;
            }
        }
        System.out.println(System.nanoTime()-start);
        return counter;
    }
    public Integer countR(Node top){
        Long start =System.nanoTime();

        if(top==null){
            System.out.println(System.nanoTime()-start);
            return 0;
        }
        else {
           return 1+countR(top.next);
        }
    }
   class Node{
        Object data;
        Node next = null;
        Node(Object data){
            this.data=data;
        }
    }

    public static void main(String[] args) {
        Stack1 st =new Stack1();
        st.push("hello1");
        st.push("hello2");
        st.push("hello3");
        st.push("hello4");
        for (int i = 5; i < 1000; i++) {
            st.push("hello"+i);
        }
        System.out.println(st.countR(st.top));
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        //System.out.println(st.countR(st.top));
    }
}
