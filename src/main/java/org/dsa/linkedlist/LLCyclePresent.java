package org.dsa.linkedlist;

public class LLCyclePresent {
    //the idea is we need to check the cycle exist in the linked list or not
    //whenever any questions asked to find cycle we need to apply slow and fast pointer approach
    //it means the slow will move by one time and fast will move by two times
    //If a cycle presents then at one point of time both slow and fast pointer will meet
    //If we meet return true , If not cycle not present return false

    public static void main(String[] args) {




    }

    private class LL{
        private Node head;


        public boolean checkCycle(LL node){

            Node slow = node.head;
            Node fast = node.head;

            while(fast !=null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast){
                    return true;
                }
            }
            return false;
        }

        //count the cycle
        // in this approach once slow and fast meets at position , just move only slow point and count
        //till the slow point reach again to slow
        // means taking one temp and move
        public int checkCycleCount(LL node){

            Node slow = node.head;
            Node fast = node.head;

            while(fast !=null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast){
                    Node temp = slow;
                    int length =0;
                    do {
                        temp = temp.next;
                        length += 1;
                    }while (temp != slow);
                    return length;
                }
            }
            return 0;
        }
        private class Node{
            private int value;
            private Node next;

            public Node(int value) {
                this.value = value;
            }
        }
    }


}
