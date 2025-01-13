package _LinkedList;

public class LinkedList5 {

    public static void main(String[] args) {
//        ListNode listNode =new ListNode(1);
//        insert(listNode,2);
//        insert(listNode,3);
//        insert(listNode,4);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Creates a cycle
        hasCycle2(node1);
    }
        private static void insert(ListNode head,int val){
            ListNode current= head;
            while(current.next!=null){
                current=current.next;
            }
          current.next=new ListNode(val);
        }

        public static boolean hasCycle(ListNode head) {
            ListNode slow =head ;
            ListNode fast= head;
            while(fast !=null && fast.next!=null){
                slow=slow.next;
                fast= fast.next.next;
                if(fast==slow){
                    return true;
                }
            }
            return false;
        }
/*
Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
 Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed).
  It is -1 if there is no cycle. Note that pos is not passed as a parameter.
 */
    public static ListNode hasCycle2(ListNode head) {
        ListNode searchList =head ;
        ListNode slow =head ;
        ListNode fast= head;
        boolean ishasCycle=false;
        int item =0;
        while(fast !=null && fast.next!=null){
            slow=slow.next;
            fast= fast.next.next;
            if(fast==slow){
                ishasCycle=true;
                item=fast.next.val;
                break;
            }
        }
        if(ishasCycle){
            while (searchList!=null && searchList.val!=item){
                searchList=searchList.next;
            }
            return searchList;
        }
         return new ListNode(-1);
    }
   static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
