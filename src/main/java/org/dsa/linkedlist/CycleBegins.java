package org.dsa.linkedlist;

import java.util.List;

public class CycleBegins {

    //Given head of LL , return the node where cycle begins. If there no cycles presents retuen null.
    //i/p [3,2,0,4] and 4 points to 2 means need to return index 1
    // because the index one is the start point of cycle
    //approach like below
    //Find the length of the cycle
    //move the slow pointer till length times
    // move slow and fast pointer till they meet then return the node



    public static ListNode findTheIndex(ListNode head){

        int length = getLength(head);
        if(length == 0){
            return null;
        }

        ListNode first = head;
        ListNode second = head;

        // move the start node till length times
        while (length > 0){
            second = second.next;
            length -= 1;
        }

       //move both first and second till they are equal
        while (first != second){
            first = first.next;
            second = second.next;
        }
        return first;
    }

    public static int getLength(ListNode head){

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                int length =0;
                ListNode temp = slow;
                do {
                    temp = temp.next;
                    length += 1;
                }while (temp != slow);
                return length;
            }
        }
        return 0;
    }
    private class ListNode{
        private int value;
        private ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }
}
