package org.dsa.linkedlist;

public class InPlaceReversalLL {

    public static void main(String[] args) {

        // the idea of in place reverseal is
        // take two pointer prev , present , next
        // while moving to next change the next to prev and move prev , move present and move next
        // execute till present not equal to null
        //finally return thr head a prev

        CustomLL ll = new CustomLL();
        ll.add(5);
        ll.add(4);
        ll.add(3);
        ll.add(2);
        ll.add(1);
        ll.display();
        ll.inPlaceReverse();
        ll.display();

        System.out.println("::::::::::::::::::::::::::::::::::");

        //Given the head of LL and two integers left and right where left <= right ,
        //reverse the nodes of the list from position left ro position right and return the reverse list
        //Example 1->2->3->4->5-> , left 2 and right =4
        // answer is 1-> 4 -> 3 -> 2 -> 5
        // The approach is simple we need to traverse till left and the previous will be pointing to left-1
        //now we will use same approach to reverse from left till right
        //after we are adjusting the next and end elements

        CustomLL ll1 = new CustomLL();
        ll1.add(1);
        ll1.add(2);
        ll1.add(3);
        ll1.add(4);
        ll1.add(5);
        ll1.display();

        ll1.inPlaceReverse2(1,4);
        ll1.display();



    }
}
