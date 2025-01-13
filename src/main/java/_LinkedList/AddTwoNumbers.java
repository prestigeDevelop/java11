package _LinkedList;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 =new ListNode(2);
        //ListNode temp =new ListNode(4);
       // l1.next=new ListNode(4);;
       // temp.next=new ListNode(3);;
        insert(l1,4);
        insert(l1,3);
        System.out.print(l1);
        ///////////////////////
        ListNode l2 =new ListNode(5);
        //ListNode temp =new ListNode(4);
        // l1.next=new ListNode(4);;
        // temp.next=new ListNode(3);;
        insert(l2,6);
        insert(l2,4);
        System.out.print(l2);
        addTwoNumbers(l1,l2);
    }
    public static void insert(ListNode list,int val){
        ListNode temp =new ListNode(val);
        if(list==null){
            list=temp;
        }
        while (list.next!=null) {
            list = list.next;
        }
        list.next = temp;
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        int carry=0;
        int temp=0;
        while(l1 != null || l2 !=null ||carry >0){
            if(l1 != null){
                temp+=l1.val;
                l1=l1.next;
            }
            if(l2 != null){
                temp+=l2.val;
                l2=l2.next;
            }
            int nextNumberToAdd=0;
            temp+=carry;
            if(temp>9){
                carry++;
                nextNumberToAdd=temp-10;
            }else{
                nextNumberToAdd=temp;
                if(carry>0)carry--;
            }
            temp=0;

            current.next = new ListNode(nextNumberToAdd);
            current=current.next;
        }
        return dummy.next;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

