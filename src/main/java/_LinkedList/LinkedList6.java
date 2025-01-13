package _LinkedList;

import static _LinkedList.LinkedList6.ListNode.addNodeToSortedList;

public class LinkedList6 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next=node2;
        node2.next=node4;
        node4.next=node5;

        ListNode node3 = new ListNode(0);

        addNodeToSortedList(node1,node3);
        System.out.println(node1);
    }

    public static ListNode sortTheList(ListNode head){


        return head;
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }

        public static ListNode addNodeToSortedList(ListNode head,ListNode toAdd){

            ListNode current =head;
            ListNode prev =head;
            while(current!=null /*&& current.val<node3.val*/){
                if(current.val<toAdd.val) {
                    prev = current;
                    current = current.next;
                    prev.next=toAdd;
                    toAdd.next=current;
                }else {
                    toAdd.next=current;
                    head=toAdd;
                }
                break;
            }
            return head;
        }
        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
