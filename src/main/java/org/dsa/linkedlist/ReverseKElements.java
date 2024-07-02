package org.dsa.linkedlist;

public class ReverseKElements {

    public static void main(String[] args) {

        CustomLL ll = new CustomLL();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);
        ll.add(7);
        ll.display();
        ll.reverseKTimes(2);
        ll.display();

    }
}
